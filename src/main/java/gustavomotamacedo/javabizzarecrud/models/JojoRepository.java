package gustavomotamacedo.javabizzarecrud.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JojoRepository extends CrudRepository<Jojo, Long> {

}
