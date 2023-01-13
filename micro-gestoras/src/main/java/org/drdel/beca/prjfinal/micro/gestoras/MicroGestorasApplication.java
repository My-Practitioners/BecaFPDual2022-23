package org.drdel.beca.prjfinal.micro.gestoras;

import org.drdel.beca.prjfinal.micro.gestoras.configuration.LocalDateConverter;
import org.drdel.beca.prjfinal.micro.gestoras.configuration.LocalDateTimeConverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.oas.annotations.EnableOpenApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "org.drdel.beca.prjfinal.micro.gestoras", "org.drdel.beca.prjfinal.micro.gestoras.api" , "org.drdel.beca.prjfinal.micro.gestoras.configuration"})
public class MicroGestorasApplication implements CommandLineRunner {

    @Override
    public void run(String... arg0) {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) {
        new SpringApplication(MicroGestorasApplication.class).run(args);
    }

    @Configuration
    static class CustomDateConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
            registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        }
    }

    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
