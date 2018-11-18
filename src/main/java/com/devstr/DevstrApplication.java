package com.devstr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DevstrApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DevstrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
