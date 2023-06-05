package org.drdel.beca.prjfinal.micro.operaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = { "org.drdel.beca.prjfinal.micro.operaciones", "org.drdel.beca.prjfinal.micro.operaciones.api" , "org.drdel.beca.prjfinal.micro.operaciones.configuration"})
@EnableWebMvc
public class MicroOperacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroOperacionesApplication.class, args);
	}

	@Configuration
	public class AppConfig {
		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	}

}
