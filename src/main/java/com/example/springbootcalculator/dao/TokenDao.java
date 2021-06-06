package com.example.springbootcalculator.dao;


import com.example.springbootcalculator.entity.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TokenDao {
    private List<Token> tokens = new ArrayList<>();

    public void save(Token token){
        tokens.add(token);
    }

    public Token getByToken(String token){
        return tokens.stream().filter(t -> t.getToken().equals(token)).findFirst().orElse(null);
    }

    public void delete(String token){
        tokens.remove(getByToken(token));
        System.out.println(tokens);
    }

    public boolean contain(String token){
        return tokens.stream().filter(t -> t.getToken().equals(token)).findFirst().orElse(null) != null;
    }

}
