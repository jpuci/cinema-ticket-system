package com.cinema.cinema;

import com.cinema.cinema.service.JsonLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

    @Autowired
    private JsonLoaderService jsonLoaderService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        jsonLoaderService.loadJsonData();
    }
}
