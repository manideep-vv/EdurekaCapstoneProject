package com.edureka;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt = SpringApplication.run(CustomerServiceApplication.class, args);

		CheckTheHealtOfNotificationMicroService(cxt);
	}

	private static void CheckTheHealtOfNotificationMicroService(ConfigurableApplicationContext cxt) {

	}


}
