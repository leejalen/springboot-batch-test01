package com.example.springbootbatchtest01;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leejalen
 */
@SpringBootApplication
@EnableBatchProcessing
public class SpringbootBatchTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBatchTest01Application.class, args);
    }

}
