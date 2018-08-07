package ar.com.zumma.sparrowplatform.repositories;

import ar.com.zumma.sparrowplatform.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, String>{

    public Optional<Role> findByName(String name);
}
