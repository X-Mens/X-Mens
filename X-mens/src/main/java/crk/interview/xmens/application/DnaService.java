package crk.interview.xmens.application;

import crk.interview.xmens.domain.model.Dna;
import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.repository.DnaRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static crk.interview.xmens.infra.config.redis.CacheConfiguration.MUTANT_CACHE;

@Service
public class DnaService {

    DnaRepository adnRepository;
    SenderDna senderMessageBroker;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @Autowired
    public DnaService(DnaRepository adnRepository, SenderDna senderMessageBroker) {

        this.adnRepository = adnRepository;
        this.senderMessageBroker = senderMessageBroker;
    }

    @Cacheable(MUTANT_CACHE)
    public boolean isMutant(Dna adn) {

        DnaType dnaState = adn.isMutant();
        String idDna = UUID.randomUUID().toString();
        adnRepository.saveResultIsMutantAdn(idDna, dnaState);
        senderMessageBroker.publishResultDnaAnalysis(dnaState, idDna);

        return dnaState == DnaType.MUTANT;
    }

}
