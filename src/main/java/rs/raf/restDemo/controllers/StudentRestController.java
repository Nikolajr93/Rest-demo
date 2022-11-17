package rs.raf.restDemo.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.raf.restDemo.model.Student;
import rs.raf.restDemo.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentById(@RequestParam("studentId") Integer studentId){
        Optional<Student> optionalStudent = studentService.findById(studentId);
        if(optionalStudent.isPresent()){
            return ResponseEntity.ok(optionalStudent.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student updateStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
