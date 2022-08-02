package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.exception.InvalidLoginException;
import com.revature.model.User;

import java.sql.SQLException;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public User login(String username, String password) throws SQLException, InvalidLoginException {
        User user = userDao.getUserByUsernameAndPassword(username, password);

        if (user == null) {
            throw new InvalidLoginException("Username and/or password is incorrect");
        }

        return user;
    }
}
