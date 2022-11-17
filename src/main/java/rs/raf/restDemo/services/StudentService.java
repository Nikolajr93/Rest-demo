package rs.raf.restDemo.services;

import org.springframework.stereotype.Service;
import rs.raf.restDemo.model.Student;
import rs.raf.restDemo.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public <S extends Student> S save(S student){
        return studentRepository.save(student);
    }

    public Optional<Student> findById(Integer studentID){
        return studentRepository.findById(studentID);
    }

    public List<Student> findAll(){
        return (List<Student>) studentRepository.findAll();
    }

    public void deleteById(Integer studentID){
        studentRepository.deleteById(studentID);
    }

}
