package com.avinty.hr.runner;

import com.avinty.hr.model.Brand;
import com.avinty.hr.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BrandRunner {

    @Bean
    CommandLineRunner brandCommandLineRunner(BrandRepository repository) {
        return args -> {
            repository.saveAll(
                List.of(
                    new Brand("Ford"),
                    new Brand("Toyota"),
                    new Brand("Ferrari"),
                    new Brand("Alfa Romeo"),
                    new Brand("Aston Martin")
                )
            );
        };
    }

}
