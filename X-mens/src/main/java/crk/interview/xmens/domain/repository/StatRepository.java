package crk.interview.xmens.domain.repository;

import crk.interview.xmens.domain.model.DnaType;

public interface StatRepository {

    void increaseCounterByDnaType(DnaType dnaType);

}
