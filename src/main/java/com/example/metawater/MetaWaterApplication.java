package com.example.metawater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class MetaWaterApplication {
    public static void main(String[] args) {SpringApplication.run(MetaWaterApplication.class, args);}
}


