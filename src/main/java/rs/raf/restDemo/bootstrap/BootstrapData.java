package rs.raf.restDemo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.raf.restDemo.model.*;
import rs.raf.restDemo.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final PredmetRepository predmetRepository;
    private final SmerRepository smerRepository;
    private final ProfesorRepository profesorRepository;

    @Autowired
    public BootstrapData(StudentRepository studentRepository, PredmetRepository predmetRepository, SmerRepository smerRepository, ProfesorRepository profesorRepository) {
        this.studentRepository = studentRepository;
        this.predmetRepository = predmetRepository;
        this.smerRepository = smerRepository;

        this.profesorRepository = profesorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Data...");

        Smer smer1 = new Smer();
        smer1.setSifra("RI");
        smer1.setPredmeti(new ArrayList<Predmet>());
        smerRepository.save(smer1);

        Smer smer2 = new Smer();
        smer2.setSifra("RN");
        smer2.setPredmeti(new ArrayList<Predmet>());
        smerRepository.save(smer2);

        Student student1 = new Student();
        student1.setFirst_name("Misa");
        student1.setLast_name("Misic");
        student1.setPredmeti(new ArrayList<Predmet>());


        Student student2 = new Student();
        student2.setFirst_name("Petar");
        student2.setLast_name("Petrovic");
        student2.setPredmeti(new ArrayList<Predmet>());

        Profesor profesor1 = new Profesor();
        Profesor profesor2 = new Profesor();
        profesorRepository.save(profesor1);
        profesorRepository.save(profesor2);

        Predmet predmet1 = new Predmet();
        predmet1.setNaziv("Mikroservisne aplikacije");
        Predmet predmet2 = new Predmet();
        predmet2.setNaziv("Napredno veb programiranje");
        predmetRepository.save(predmet1);
        predmetRepository.save(predmet2);

        studentRepository.save(student1);
        studentRepository.save(student2);

        //  Vršenje izmene (Update)

        student1.setFirst_name("Laza");
        student1.setLast_name("Lazic");
        student1.setSmer(smer1);
        student2.setSmer(smer1);
        studentRepository.save(student1);
        studentRepository.save(student2);

        //  Povezivanje Profesora, Predmeta i Smera

        profesor1.setPredmet(predmet1);
        predmet1.setProfesor(profesor1);
        predmet1.setSmer(smer1);
        smer1.getPredmeti().add(predmet1);
        profesor2.setPredmet(predmet2);
        predmet2.setProfesor(profesor2);
        predmet2.setSmer(smer1);
        smer1.getPredmeti().add(predmet2);
        profesorRepository.save(profesor1);
        predmetRepository.save(predmet1);
        predmetRepository.save(predmet2);
        smerRepository.save(smer1);

        //  Povezivanje Studenata i Predmeta

        List<Student> studentiZaPredmet1 = new ArrayList<>();
        studentiZaPredmet1.add(student1);
        studentiZaPredmet1.add(student2);

        List<Student> studentiZaPredmet2 = new ArrayList<>();
        studentiZaPredmet2.add(student1);

        List<Predmet> predmetiZaStudenta1 = new ArrayList<>();
        predmetiZaStudenta1.add(predmet1);
        predmetiZaStudenta1.add(predmet2);

        List<Predmet> predmetiZaStudenta2 = new ArrayList<>();
        predmetiZaStudenta2.add(predmet1);

        student1.setPredmeti(predmetiZaStudenta1);
        predmet1.setStudenti(studentiZaPredmet1);
        student2.setPredmeti(predmetiZaStudenta2);
        predmet2.setStudenti(studentiZaPredmet2);
//        studRepo.save(student1);
//        studRepo.save(student2);
        predmetRepository.save(predmet1);
        predmetRepository.save(predmet2);

        System.out.println("Data loaded!");
    }
}
