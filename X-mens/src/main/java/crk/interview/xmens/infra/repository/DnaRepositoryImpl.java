package crk.interview.xmens.infra.repository;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.repository.DnaRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DnaRepositoryImpl implements DnaRepository {

    private final DnaDynamoDbRepository dnaDynamoDbRepository;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @Autowired
    public DnaRepositoryImpl(DnaDynamoDbRepository dnaDynamoDbRepository) {
        this.dnaDynamoDbRepository = dnaDynamoDbRepository;
    }

    @Override
    public void saveResultIsMutantAdn(String idDna, DnaType type) {

        DnaTable dnaTable = new DnaTable(idDna, type);
        dnaDynamoDbRepository.save(dnaTable);
    }
}
