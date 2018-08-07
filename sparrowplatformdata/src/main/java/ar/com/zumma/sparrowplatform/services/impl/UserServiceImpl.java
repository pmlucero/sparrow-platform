package ar.com.zumma.sparrowplatform.services.impl;

import ar.com.zumma.sparrowplatform.model.User;
import ar.com.zumma.sparrowplatform.repositories.UserRepository;
import ar.com.zumma.sparrowplatform.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User save(User object) {
        return repo.save(object);
    }

    @Override
    public Optional<User> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public void delete(User object) {
        repo.delete(object);
    }

    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
