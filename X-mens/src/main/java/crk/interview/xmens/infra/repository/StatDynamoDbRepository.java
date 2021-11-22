package crk.interview.xmens.infra.repository;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.repository.StatRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatDynamoDbRepository implements StatRepository {

    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @Override
    public void increaseCounterByDnaType(DnaType dnaType) {

    }
}
