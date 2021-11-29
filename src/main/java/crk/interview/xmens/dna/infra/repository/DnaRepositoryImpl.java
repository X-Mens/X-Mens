package crk.interview.xmens.dna.infra.repository;

import crk.interview.xmens.dna.domain.repository.DnaRepository;
import crk.interview.xmens.share.domain.model.DnaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DnaRepositoryImpl implements DnaRepository {

    private final DnaDynamoDbRepository dnaDynamoDbRepository;

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
