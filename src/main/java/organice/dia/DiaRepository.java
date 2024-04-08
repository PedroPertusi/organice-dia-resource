package organice.dia;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaRepository extends CrudRepository<DiatModel, String> {
    
    // Optional<AccountModel> findByEmailAndHash(String email, String hash);

    
}
