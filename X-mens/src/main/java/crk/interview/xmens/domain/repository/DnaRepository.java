package crk.interview.xmens.domain.repository;

import crk.interview.xmens.domain.model.DnaType;

public interface DnaRepository {

    void saveResultIsMutantAdn(String idDna, DnaType isMutant);
}
