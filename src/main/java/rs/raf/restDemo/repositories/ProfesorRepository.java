package rs.raf.restDemo.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.restDemo.model.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {
}
