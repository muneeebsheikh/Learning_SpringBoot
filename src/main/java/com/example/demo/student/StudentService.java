package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void deleteStudent(Long studentId) {
        if(!repository.existsById(studentId))
            throw new IllegalStateException("Student with id {" + studentId + "} does not exist");
        repository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id {"+ studentId +"} does not exist"));

        if(name != null && !name.isBlank() && !name.equals(student.getName())){
            student.setName(name);
        }
        if(email != null && !email.equals(student.getEmail()) && !email.isBlank()){
            Optional<Student> studentOptional = repository.findStudentByEmail(email);
            if(studentOptional.isPresent())
                throw new IllegalStateException("Email is Taken");
            student.setEmail(email);
        }

    }
}
