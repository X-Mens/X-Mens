package crk.interview.xmens.infra.events;

import crk.interview.xmens.domain.model.DnaType;
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
        DnaAnalysisModel change = new DnaAnalysisModel(
                DnaAnalysisModel.class.getTypeName(),
                adnState.toString(),
                adnId);
        output.send(MessageBuilder.withPayload(change).build());
    }

}
