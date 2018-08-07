package ar.com.zumma.sparrow.services;

public interface RepoServices<T, String> {

    public T save(T object);

    public T findById(String id);

    public void delete(T object);

    public Iterable<T> findAll();
}
