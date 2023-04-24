package com.example.metawater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
public class MetaWaterApplication {
    public static void main(String[] args) {SpringApplication.run(MetaWaterApplication.class, args);}
}


