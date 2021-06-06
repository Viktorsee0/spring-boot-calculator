package com.example.springbootcalculator.dao;

import com.example.springbootcalculator.entity.calc.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao {
    private List<User> users = new ArrayList<>();
    private long incId = 1;

    public void save(User user){
        user.setId(incId++);
        users.add(user);
    }

    public Optional<User> getByLogin(String login){
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

    public Optional<User> getById(long id){
        return users.stream().filter(user -> user.getId() == (id)).findFirst();
    }

    public boolean contains(String login){
        for (User user : users){
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

}
