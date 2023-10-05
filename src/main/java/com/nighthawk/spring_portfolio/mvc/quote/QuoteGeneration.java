package com.nighthawk.spring_portfolio.mvc.quote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuoteGeneration {

    @Bean
    CommandLineRunner commandLineRunner(
            QuoteJpaRepository repository) {
        return args -> {
            Quote q1 = new Quote(
                "When life gives you lemons, make lemonade", 
                "happy"
            ); 

            Quote q2 = new Quote(
                "Keep calm and carry on", 
                "sad"
            );

            repository.saveAll(
                    List.of(q1, q2)
            );
        };
    }
}
