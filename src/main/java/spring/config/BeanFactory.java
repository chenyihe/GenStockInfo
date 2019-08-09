package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.processor.Utils;


@Configuration
public class BeanFactory {

    @Bean
    public Utils utilsFactory(){
        return new Utils();
     }

}
