package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class BeanConfig {
    @Bean(name = "scanBean") // Defining name for the bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
