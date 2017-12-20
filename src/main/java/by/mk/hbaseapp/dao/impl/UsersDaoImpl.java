package by.mk.hbaseapp.dao.impl;

import by.mk.hbaseapp.dao.UsersDao;
import by.mk.hbaseapp.model.Users;

public class UsersDaoImpl extends AbstractDaoImpl<Users, String> implements UsersDao {

    protected UsersDaoImpl(){
        super(Users.class);
    }

    @Override
    public void find(String key) {

    }
}
