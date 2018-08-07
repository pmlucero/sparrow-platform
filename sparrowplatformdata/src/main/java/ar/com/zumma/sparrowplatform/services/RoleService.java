package ar.com.zumma.sparrowplatform.services;

import ar.com.zumma.sparrowplatform.model.Role;

import java.util.Optional;

public interface RoleService extends RepoServices<Role, String> {

    Optional<Role> findByName(String name);
}
