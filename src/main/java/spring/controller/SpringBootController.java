package spring.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.domain.Stock;
import spring.processor.Utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


@Component
@RestController
public class SpringBootController {


    private Logger logger = LoggerFactory.getLogger(SpringBootController.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapservers;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.bootstrap-servers}")
    private String boot1;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    @Value("${spring.kafka.topic.kafkaTopic_1}")
    private String kafkatopic_1;

    @Autowired
    private Utils utils;

    @Autowired
    private SpringBootController springBootController;

    @RequestMapping("/hello")
    public String hello(){
        return "bootstrapServers:--->"+bootstrapservers +"\n"
                + "kafkaproducer:--->"+kafkaProducer    +"\n"
                + "kafkaTemplate:--->"+kafkaTemplate    +"\n"
                + "boot1:--->"+boot1                    +"\n"
                + "consumerGroupId:--->"+consumerGroupId+"\n"
                + "autoOffsetReset:--->"+autoOffsetReset+"\n"
                + "utils:--->"+this.utils;
    }

    @GetMapping("/send/{message}")
    public void send(@PathVariable String message){
        System.out.println(message);
        ListenableFuture<SendResult<String,String>> future = this.kafkaTemplate.send("test02", message);
        future.addCallback(new ListenableFutureCallback<SendResult<String,String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.error("消息：{},发送失败,失败原因:{}",message,throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String,String> sendResult) {
                logger.info("成功发送消息：{},offset=[{}]",message,sendResult.getRecordMetadata().offset());
            }
        });
    }

    @Scheduled(cron="0 */1 * * * ?")
//    @RequestMapping("/sendInfo")
    public String sendInfo() throws MalformedURLException, UnsupportedEncodingException {
        this.springBootController.sendStockInfo();
        return "Ok";
    }


    public void sendStockInfo() throws MalformedURLException, UnsupportedEncodingException {
        System.out.println(this.utils);
        List<Stock> stocks = new ArrayList<>();
        System.out.println("utils--------------->"+this.utils);
        List<String> pathList = this.utils.getPath();
        for(String str:pathList){
            String stockInfo = this.utils.getStockInfo(str);
            stocks=this.utils.genStock(stockInfo);
            for(Stock stock : stocks){
                String message =  stock.toString();
                System.out.println(message);
                ListenableFuture<SendResult<String,String>> future = this.kafkaTemplate.send("kafkatopic_1","上证", message);
                future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        logger.error("消息：{},发送失败,失败原因:{}",message,throwable.getMessage());
                    }

                    @Override
                    public void onSuccess(SendResult<String, String> stringStringSendResult) {
                        logger.info("成功发送消息：{},offset=[{}]",message,stringStringSendResult.getRecordMetadata().offset());
                    }
                });
            }
        }


    }
}
