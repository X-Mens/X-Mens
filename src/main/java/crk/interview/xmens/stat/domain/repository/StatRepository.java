package crk.interview.xmens.stat.domain.repository;

import crk.interview.xmens.share.domain.model.DnaType;
import crk.interview.xmens.stat.domain.model.Stat;

public interface StatRepository {

    void increaseCounterByDnaType(DnaType dnaType);

    Stat getStatDnaAnalysis();

}
