package com.example.springbootcalculator.service;

import com.example.springbootcalculator.dao.UserDao;
import com.example.springbootcalculator.entity.calc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    UserDao dao;

    public Boolean save(User user) {
        if (!dao.contains(user.getLogin())) {
            dao.save(user);
            return true;
        }
        return false;
    }

    public User authorization(String login, String password) {
        User user = dao.getByLogin(login).orElse(null);
        return user;
    }

    public User getById(long id) {
        return dao.getById(id).orElse(null);
    }

}
