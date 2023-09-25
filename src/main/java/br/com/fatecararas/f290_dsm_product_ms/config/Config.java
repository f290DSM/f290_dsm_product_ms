package br.com.fatecararas.f290_dsm_product_ms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate confifRestTemplate() {
        return new RestTemplate();
    }
}
