package org.copper.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsManagerApplication.class, args);
    }

}
