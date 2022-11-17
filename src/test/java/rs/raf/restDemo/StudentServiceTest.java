package rs.raf.restDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rs.raf.restDemo.model.Student;
import rs.raf.restDemo.repositories.StudentRepository;
import rs.raf.restDemo.services.StudentService;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;
	
	@Test
    public void saveStudentTest() throws Exception {
		
        Student student1 = new Student();
        student1.setFirst_name("Misa");
        student1.setLast_name("Misic");

        Student student2 = new Student();
        student2.setFirst_name("Petar");
        student2.setLast_name("Petrovic");

        studentService.save(student1);
        studentService.save(student2);

        List<Student> students = studentService.findAll();
        System.out.println(students);

        student1.setFirst_name("Laza");
        student1.setLast_name("Lazic");
        studentService.save(student1);

        Optional<Student> optionalStudent = studentService.findById(1);
        if(optionalStudent.isPresent()){
            System.out.println(optionalStudent.get());
        }

        studentService.deleteById(2);
        students = studentService.findAll();
        System.out.println(students);
        
    }
        
   }

