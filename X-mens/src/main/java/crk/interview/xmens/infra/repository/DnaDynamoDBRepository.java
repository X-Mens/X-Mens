package crk.interview.xmens.infra.repository;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.repository.DnaRepository;
import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DnaDynamoDBRepository implements DnaRepository {

    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @Override
    public void saveResultIsMutantAdn(String idDna, DnaType isMutant) {

    }
}
