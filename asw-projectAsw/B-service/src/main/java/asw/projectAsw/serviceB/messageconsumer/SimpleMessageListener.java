package asw.projectAsw.serviceB.messageconsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.stereotype.Component;

import asw.projectAsw.serviceB.domain.ServiceBConsumer;

import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@Component 
public class SimpleMessageListener {

    private Logger logger = Logger.getLogger(SimpleMessageListener.class.toString());

	@Value("${asw.kafka.channel.in}")
	private String channel;

	@Value("${asw.kafka.groupid}")
	private String groupId;

    @Autowired
    private ServiceBConsumer simpleConsumerService;

	@KafkaListener(topics = "${asw.kafka.channel.in}", groupId="${asw.kafka.groupid}")
    public void listen(ConsumerRecord<String, String> record) throws Exception {
        String message = record.value();
		simpleConsumerService.onMessage(message); 
    }

}
