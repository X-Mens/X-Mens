package crk.interview.xmens.infra.repository;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.model.Stat;
import crk.interview.xmens.domain.repository.StatRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatRepositoryImpl implements StatRepository {

    StatDynamoDbRepository statDynamoDbRepository;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @Autowired
    public StatRepositoryImpl(StatDynamoDbRepository statDynamoDbRepository) {
        this.statDynamoDbRepository = statDynamoDbRepository;
    }

    @Override
    public void increaseCounterByDnaType(DnaType dnaType) {
        switch (dnaType){
            case MUTANT:
                statDynamoDbRepository.increaseCountHumanDna();
            case HUMAN:
                statDynamoDbRepository.increaseCountMutantDna();
        }
    }

    @Override
    public Stat getStatDnaAnalysis() {

        statDynamoDbRepository.findAll();
        return null;
    }
}
