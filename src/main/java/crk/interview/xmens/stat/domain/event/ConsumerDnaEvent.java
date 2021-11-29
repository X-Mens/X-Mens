package crk.interview.xmens.stat.domain.event;


import crk.interview.xmens.share.infra.events.DnaAnalysisModel;

public interface ConsumerDnaEvent {

    void handlerDnaEvent(DnaAnalysisModel dnaAnalysisModel);

}
