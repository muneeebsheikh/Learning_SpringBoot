package com.example.demo.student;

import org.hibernate.boot.model.relational.Database;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository repository){
        return  args -> {
//            Student muneeb = new Student(
//                    "MuneebS",
//                    "muneeb@gmail.com",
//                    LocalDate.of(1990 , Month.JANUARY, 11)
//            );
//            Student ali = new Student(
//                    "AliS",
//                    "ali@gmail.com",
//                    LocalDate.of(2003, Month.JANUARY, 11)
//            );
//            repository.saveAll(
//                    List.of(muneeb, ali)
//            );
        };
    }
}
