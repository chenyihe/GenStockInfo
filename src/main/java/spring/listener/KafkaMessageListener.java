package spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaMessageListener {

    private Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);


    @KafkaListener(topics="test02", group="test_group_id_01")
    public void listen(String message){
        logger.info("接受消息：{}",message);
    }
}
