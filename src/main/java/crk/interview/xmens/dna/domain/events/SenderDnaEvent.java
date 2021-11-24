package crk.interview.xmens.dna.domain.events;

import crk.interview.xmens.share.domain.model.DnaType;

public interface SenderDnaEvent {

    void publishResultDnaAnalysis(DnaType adnState, int adnId);
}
