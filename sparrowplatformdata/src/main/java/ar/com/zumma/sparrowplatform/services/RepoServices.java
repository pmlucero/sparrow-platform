package ar.com.zumma.sparrowplatform.services;

import java.util.Optional;

public interface RepoServices<T, String> {

    public T save(T object);

    public Optional<T> findById(String id);

    public void delete(T object);

    public Iterable<T> findAll();
}
