package app.daos;


import java.util.List;

public interface IDAO<T, I> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(I i);
    List<T> findAll();
}
