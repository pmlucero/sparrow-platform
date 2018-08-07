package ar.com.zumma.sparrowplatform.services.impl;

import ar.com.zumma.sparrowplatform.model.Role;
import ar.com.zumma.sparrowplatform.repositories.RoleRepository;
import ar.com.zumma.sparrowplatform.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Role save(Role object) {
        return repo.save(object);
    }

    @Override
    public Optional<Role> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Role object) {
        repo.delete(object);
    }

    @Override
    public Iterable<Role> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Role> findByName(String name) {
        return repo.findByName(name);
    }
}
