package crk.interview.xmens.stream;

import crk.interview.xmens.XMensApplication;
import crk.interview.xmens.share.domain.model.DnaType;
import crk.interview.xmens.share.infra.events.CustomChannels;
import crk.interview.xmens.share.infra.events.DnaAnalysisModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.BlockingQueue;

import static crk.interview.xmens.share.domain.model.DnaType.MUTANT;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = XMensApplication.class)
@DirtiesContext
@SpringBootTest(classes = XMensApplication.class)
public class MessageChannelsTest {

    @Autowired
    private CustomChannels channels;

    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void whenSendMessage_thenResponseIsInAOutput() {
        BlockingQueue<Message<?>> messages = messageCollector.forChannel(channels.mutantEventConsumerHandler());
        DnaAnalysisModel dnaAnalysisModel = new DnaAnalysisModel(MUTANT, 1);
        channels.mutantEventHandler()
                .send(MessageBuilder.withPayload(dnaAnalysisModel)
                        .build());
        Object payload = messages.poll().getPayload();
        assertEquals(dnaAnalysisModel, payload);
    }
}


