package crk.interview.xmens.stat.infra.repository;

import crk.interview.xmens.dna.infra.events.SenderKafkaDna;
import crk.interview.xmens.share.domain.model.DnaType;
import crk.interview.xmens.stat.domain.model.Stat;
import crk.interview.xmens.stat.domain.repository.StatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StatRepositoryImpl implements StatRepository {

    StatDynamoDbRepository statDynamoDbRepository;
    private static final Logger logger = LoggerFactory.getLogger(SenderKafkaDna.class);

    @Value("${aggregation.key}")
    public String hashKey;

    @Autowired
    public StatRepositoryImpl(StatDynamoDbRepository statDynamoDbRepository) {
        this.statDynamoDbRepository = statDynamoDbRepository;
    }

    @Override
    public void increaseCounterByDnaType(DnaType dnaType) {

        Optional<StatTable> statTableOptional = statDynamoDbRepository.findById(hashKey);
        StatTable statTable = statTableOptional.isEmpty() ? new StatTable(hashKey) : statTableOptional.get();
        switch (dnaType) {
            case MUTANT:
                statTable.setCountMutantDna(statTable.getCountMutantDna() + 1);
                break;
            case HUMAN:
                statTable.setCountHumanDna(statTable.getCountHumanDna() + 1);
        }
        statDynamoDbRepository.save(statTable);
    }

    @Override
    public Stat getStatDnaAnalysis() {

        StatTable statTable = statDynamoDbRepository.findById(hashKey).orElse(new StatTable(hashKey));
        return new Stat(statTable.getCountMutantDna(), statTable.getCountHumanDna());
    }
}
