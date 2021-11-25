package crk.interview.xmens.dna.domain.repository;

import crk.interview.xmens.share.domain.model.DnaType;

public interface DnaRepository {

    void saveResultIsMutantDna(int idDna, DnaType isMutant);
}
