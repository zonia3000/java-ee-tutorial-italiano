package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * È anche possibile definire i bean all'interno di una classe di configurazione
 * come questa o di un file XML (che importiamo tramite annotazione).
 */
@Configuration
@ImportResource("classpath:/config.xml") // (src/main/resources/config.xml)
public class Config {

    @Bean
    public Bean1 getBean2() {
        return new Bean1();
    }
}
