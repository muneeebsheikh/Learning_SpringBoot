package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
 public class StudentService {

    private final IStudentRepository repository;

    @Autowired
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents(){
        return  repository.findAll();
//        return  List.of(
//                new Student(
//                        1L,
//                        "Muneeb",
//                        "muneeb@gmail.com",
//                        LocalDate.of(1998, Month.JANUARY,11),
//                        23
//                )
//        );
    }
}
