package com.app.demo.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepo itemRepo) {
        return args -> {
            Item Lays = new Item (
                    "Lays",
                    2
                    );
            Item Maggie = new Item (
                    "Maggie",
                    5
            );
            itemRepo.saveAll(
                            List.of(Lays, Maggie)
                    );
        };
    }

}
