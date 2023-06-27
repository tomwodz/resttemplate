package pl.jjr.tomwodz.resttemplate.config.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    RestTemplate restTempalte(){
        return new RestTemplate();
    }
}
