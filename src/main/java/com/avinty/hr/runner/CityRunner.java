package com.avinty.hr.runner;

import com.avinty.hr.model.City;
import com.avinty.hr.repository.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CityRunner {

    @Bean
    CommandLineRunner cityCommandLineRunner(CityRepository repository) {
        return args -> {
            repository.saveAll(
                List.of(
                    new City("Pécs"),
                    new City("Komló"),
                    new City("Budapest"),
                    new City("Vidornyaszőlős")
                )
            );
        };
    }
}
