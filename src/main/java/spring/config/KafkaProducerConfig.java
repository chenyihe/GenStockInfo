package spring.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapservers;


    @Bean
    public KafkaProducer<String,String> getProducer(){
        Map<String,Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapservers);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new KafkaProducer<String, String>(map);
    }


    @Bean
    public ProducerFactory<String,String> producerFactory(){

        Map<String,Object> kafkaProerties = new HashMap<>();
        kafkaProerties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,this.bootstrapservers);
        kafkaProerties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        kafkaProerties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        kafkaProerties.put(ProducerConfig.METADATA_FETCH_TIMEOUT_CONFIG,"3000");
        return new DefaultKafkaProducerFactory<>(kafkaProerties);
    }

    @Bean
    public KafkaTemplate<String,String> getKafkaTemplate(){
        return new KafkaTemplate<String,String>(producerFactory());
    }
}
