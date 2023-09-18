package br.com.fatecararas.f290_dsm_product_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class F290DsmProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(F290DsmProductMsApplication.class, args);
	}

}
