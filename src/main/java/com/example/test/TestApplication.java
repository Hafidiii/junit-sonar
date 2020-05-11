package com.example.test;

import com.example.test.entities.User;
import com.example.test.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(UserRepository userRepository){
//
//        return (args) -> {
//            userRepository.save(new User("guess", "Bill"));
//            userRepository.save(new User("jack", "biko"));
//            userRepository.save(new User("Firbo", "deep"));
//            userRepository.save(new User("john", "macron"));
//        };
//    }
}
