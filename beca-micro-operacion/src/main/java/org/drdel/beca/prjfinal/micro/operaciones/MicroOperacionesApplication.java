package org.drdel.beca.prjfinal.micro.operaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "org.drdel.beca.prjfinal.micro.operaciones", "org.drdel.beca.prjfinal.micro.operaciones.api" , "org.drdel.beca.prjfinal.micro.operaciones.configuration"})
public class MicroOperacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroOperacionesApplication.class, args);
	}

}
