package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = repository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        repository.save(student);

    }
}
