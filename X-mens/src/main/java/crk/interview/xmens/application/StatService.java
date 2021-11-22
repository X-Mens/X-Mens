package crk.interview.xmens.application;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.model.Stat;
import crk.interview.xmens.domain.repository.StatRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    StatRepository statRepository;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public void increaseCounter(DnaType dnaType){

        statRepository.increaseCounterByDnaType(dnaType);
    }

    public Stat getStatDnaAnalysis(){

        Stat stat = statRepository.getStatDnaAnalysis();
        stat.calculateRatio();
        return stat;
    }

}
