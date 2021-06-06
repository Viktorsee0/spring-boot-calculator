package com.example.springbootcalculator.service;

import com.example.springbootcalculator.dao.TokenDao;
import com.example.springbootcalculator.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
    @Autowired
    TokenDao tokenDao;

    public void save(Token token) {
        tokenDao.save(token);
    }

    public Token getToken(String token) {
        return tokenDao.getByToken(token);
    }

    public boolean delete(String token) {
        if (tokenDao.contain(token)) {
            tokenDao.delete(token);
            return true;
        }else{
            return false;
        }
    }

}
