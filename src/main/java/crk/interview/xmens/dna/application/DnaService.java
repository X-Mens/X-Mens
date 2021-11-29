package crk.interview.xmens.dna.application;

import crk.interview.xmens.dna.domain.events.SenderDnaEvent;
import crk.interview.xmens.dna.domain.model.Dna;
import crk.interview.xmens.dna.domain.repository.DnaRepository;
import crk.interview.xmens.share.domain.model.DnaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static crk.interview.xmens.dna.infra.config.redis.CacheConfiguration.MUTANT_CACHE;

@Service
public class DnaService {

    DnaRepository adnRepository;
    SenderDnaEvent senderMessageBroker;
    private static final Logger logger = LoggerFactory.getLogger(DnaService.class);

    @Autowired
    public DnaService(DnaRepository adnRepository, SenderDnaEvent senderMessageBroker) {

        this.adnRepository = adnRepository;
        this.senderMessageBroker = senderMessageBroker;
    }

    @Cacheable(value = MUTANT_CACHE, key = "#p0")
    public boolean isMutant(int idDna, Dna adn) {

        DnaType dnaState = adn.isMutant();
        adnRepository.saveResultIsMutantDna(idDna, dnaState);
        senderMessageBroker.publishResultDnaAnalysis(dnaState, idDna);
        return dnaState == DnaType.MUTANT;
    }

}
