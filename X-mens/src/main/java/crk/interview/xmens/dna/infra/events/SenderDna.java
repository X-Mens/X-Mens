package crk.interview.xmens.dna.infra.events;

import crk.interview.xmens.share.domain.model.DnaType;
import crk.interview.xmens.share.infra.events.DnaAnalysisModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SenderDna {

    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    MessageChannel output;

    @Autowired
    public SenderDna(@Qualifier("inBoundMutant") MessageChannel output) {
        this.output = output;
    }

    public void publishResultDnaAnalysis(DnaType adnState, String adnId) {

        logger.info("Sending message kafka message {} for AdnId {}", adnState, adnId);
        DnaAnalysisModel change = new DnaAnalysisModel(adnState, adnId);
        output.send(MessageBuilder.withPayload(change).build());
    }

}
