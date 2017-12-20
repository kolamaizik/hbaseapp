package by.mk.hbaseapp.dao;

import java.util.List;

public interface AbstractDao<T, KEY> {

    List<T> getAll();

    T get(final KEY key);

    T insert(final T entity);

    T update(T entity);

    void delete(KEY key);
}
