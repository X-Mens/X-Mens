package crk.interview.xmens.infra.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(CustomChannels.class)
public class ConsumerDnaHandler {

    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @StreamListener("inBoundMutant")
    public void accept(DnaAnalysisModel dnaAnalysisModel) {
        logger.info("Received message kafka message " + dnaAnalysisModel);
    }
}
