package crk.interview.xmens.stat.infra.events;

import crk.interview.xmens.share.infra.events.CustomChannels;
import crk.interview.xmens.share.infra.events.DnaAnalysisModel;
import crk.interview.xmens.stat.application.StatService;
import crk.interview.xmens.stat.domain.event.ConsumerDnaEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(CustomChannels.class)
public class ConsumerKafkaDnaHandler implements ConsumerDnaEvent {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerKafkaDnaHandler.class);

    StatService statService;

    @Autowired
    public ConsumerKafkaDnaHandler(StatService statService) {
        this.statService = statService;
    }

    @StreamListener("inBoundMutant")
    public void handlerDnaEvent(DnaAnalysisModel dnaAnalysisModel) {
        logger.info("Received message kafka message " + dnaAnalysisModel);
        statService.increaseCounter(dnaAnalysisModel.getAdnState());
    }
}
