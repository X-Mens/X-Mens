package crk.interview.xmens.stat.infra.events;

import crk.interview.xmens.dna.infra.events.SenderDna;
import crk.interview.xmens.share.infra.events.CustomChannels;
import crk.interview.xmens.share.infra.events.DnaAnalysisModel;
import crk.interview.xmens.stat.application.StatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(CustomChannels.class)
public class ConsumerDnaHandler {

    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    StatService statService;

    @Autowired
    public ConsumerDnaHandler(StatService statService) {
        this.statService = statService;
    }

    @StreamListener("inBoundMutant")
    public void accept(DnaAnalysisModel dnaAnalysisModel) {
        logger.info("Received message kafka message " + dnaAnalysisModel);
        statService.increaseCounter(dnaAnalysisModel.getAdnState());
    }
}
