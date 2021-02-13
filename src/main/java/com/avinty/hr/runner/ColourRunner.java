package com.avinty.hr.runner;

import com.avinty.hr.model.Colour;
import com.avinty.hr.repository.ColourRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ColourRunner {

    @Bean
    CommandLineRunner colourCommandLineRunner(ColourRepository repository) {
        return args -> {
            repository.saveAll(
                List.of(
                    new Colour("blue"),
                    new Colour("white"),
                    new Colour("yellow"),
                    new Colour("green"),
                    new Colour("orange")
                )
            );
        };
    }

}
