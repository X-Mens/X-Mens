package crk.interview.xmens.application;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.repository.StatRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatService {

    StatRepository statRepository;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public void increaseCounter(DnaType dnaType){

        statRepository.increaseCounterByDnaType(dnaType);
    }



}
