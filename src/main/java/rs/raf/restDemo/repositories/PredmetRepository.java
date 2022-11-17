package rs.raf.restDemo.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.restDemo.model.Predmet;

public interface PredmetRepository extends CrudRepository<Predmet, Integer> {
}
