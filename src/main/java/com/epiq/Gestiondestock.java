package com.epiq;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAdminServer

public class Gestiondestock {
    static final Logger LOG = LoggerFactory.getLogger(Gestiondestock.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Gestiondestock.class, args);
        LOG.info("gestion de stock start");
    }


}
