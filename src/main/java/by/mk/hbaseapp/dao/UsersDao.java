package by.mk.hbaseapp.dao;

import by.mk.hbaseapp.model.Users;

public interface UsersDao extends AbstractDao<Users, String> {
    void find(String key);
}
