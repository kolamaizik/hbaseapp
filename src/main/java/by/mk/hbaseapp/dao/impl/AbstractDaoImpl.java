package by.mk.hbaseapp.dao.impl;

import by.mk.hbaseapp.dao.AbstractDao;

import java.util.List;

public class AbstractDaoImpl<T, KEY> implements AbstractDao<T, KEY> {

    private final Class<T> entityClass;

    public AbstractDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T get(KEY key) {
        return null;
    }

    @Override
    public T insert(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(KEY key) {

    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}
