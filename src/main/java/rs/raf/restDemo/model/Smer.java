package rs.raf.restDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Smer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_smer;

    private String sifra;

    @JsonIgnore
    @OneToMany(mappedBy = "smer")
    private List<Predmet> predmeti;

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setId_smer(Long id_smer) {
        this.id_smer = id_smer;
    }

    public Long getId_smer() {
        return id_smer;
    }
}
