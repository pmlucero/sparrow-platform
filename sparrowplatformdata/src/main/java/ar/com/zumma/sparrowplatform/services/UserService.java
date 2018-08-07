package ar.com.zumma.sparrowplatform.services;

import ar.com.zumma.sparrowplatform.model.User;

import java.util.Optional;

public interface UserService extends RepoServices<User, String> {

    Optional<User> findByEmail(String email);
}
