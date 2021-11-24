package crk.interview.xmens.dna.infra.repository;

import crk.interview.xmens.dna.domain.repository.DnaRepository;
import crk.interview.xmens.dna.infra.events.SenderDna;
import crk.interview.xmens.share.domain.model.DnaType;
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
    public void saveResultIsMutantDna(int idDna, DnaType type) {

        DnaTable dnaTable = new DnaTable();
        dnaTable.setType(type.toString());
        dnaTable.setIdDna(idDna);
        dnaDynamoDbRepository.save(dnaTable);
    }
}
