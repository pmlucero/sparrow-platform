package ar.com.zumma.sparrow.repositories;

import ar.com.zumma.sparrow.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmail(String email);
}
