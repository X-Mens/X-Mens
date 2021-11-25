package crk.interview.xmens.dna.application;


import crk.interview.xmens.dna.domain.events.SenderDnaEvent;
import crk.interview.xmens.dna.domain.model.Dna;
import crk.interview.xmens.dna.domain.repository.DnaRepository;
import crk.interview.xmens.share.domain.model.DnaType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Import({DnaService.class})
@ExtendWith(SpringExtension.class)
@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})
class DnaServiceTest {

    @MockBean
    private DnaRepository adnRepositoryMock;

    @MockBean
    private SenderDnaEvent senderDnaEventMock;

    @Autowired
    private DnaService dnaService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void givenRedisCaching_whenDnaServiceAskForIsMutant() {
        String[] dnaArray = new String[]{
                "TTTT",
                "TAGC",
                "TAGC",
                "TAGC",
        };
        Dna dna = new Dna(dnaArray);
        int idAdn = Arrays.deepHashCode(dnaArray);

        dnaService.isMutant(idAdn, dna);
        dnaService.isMutant(idAdn, dna);

        verify(adnRepositoryMock, times(1)).saveResultIsMutantDna(idAdn, DnaType.MUTANT);
        verify(senderDnaEventMock, times(1)).publishResultDnaAnalysis(DnaType.MUTANT, idAdn);
        assertThat(itemFromCache(idAdn)).isEqualTo(true);
    }

    private Object itemFromCache(int idAdn) {
        return cacheManager.getCache("mutant").get(idAdn).get();
    }

    @TestConfiguration
    static class EmbeddedRedisConfiguration {

        private final RedisServer redisServer;

        public EmbeddedRedisConfiguration() {
            this.redisServer = new RedisServer();
        }

        @PostConstruct
        public void startRedis() {
            redisServer.start();
        }

        @PreDestroy
        public void stopRedis() {
            this.redisServer.stop();
        }
    }
}