package crk.interview.xmens.domain.repository;

import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.domain.model.Stat;

public interface StatRepository {

    void increaseCounterByDnaType(DnaType dnaType);

    Stat getStatDnaAnalysis();

}
