package com.picoplaca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.picoplaca"})
public class PicoPlacaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicoPlacaApplication.class, args);
    }
}
