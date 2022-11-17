package rs.raf.restDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rs.raf.restDemo.model.Student;
import rs.raf.restDemo.repositories.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
    StudentRepository studRepo;
	
	@Test
    public void saveStudentTest() throws Exception {
		
        Student student1 = new Student();
        student1.setFirst_name("Misa");
        student1.setLast_name("Misic");

        Student student2 = new Student();
        student2.setFirst_name("Petar");
        student2.setLast_name("Petrovic");
        
        studRepo.save(student1);
        studRepo.save(student2);
        
    }
        
   }

