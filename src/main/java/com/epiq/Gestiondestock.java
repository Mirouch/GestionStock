package com.epiq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class Gestiondestock {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Gestiondestock.class, args);
    }

}
