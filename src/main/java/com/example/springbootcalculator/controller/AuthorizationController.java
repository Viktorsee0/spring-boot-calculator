package com.example.springbootcalculator.controller;

import com.example.springbootcalculator.entity.Token;
import com.example.springbootcalculator.entity.calc.User;
import com.example.springbootcalculator.service.TokenService;
import com.example.springbootcalculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class AuthorizationController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/reg")
    public ResponseEntity<Boolean> registration(@RequestBody User user) {
        Boolean save = userService.save(user);
        return new ResponseEntity<>(save, HttpStatus.ACCEPTED);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> authorization(@RequestBody User user) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();

        user = userService.authorization(user.getLogin(), user.getPassword());
        System.out.println(user);
        if (user != null) {
            tokenService.save(new Token(user.getId(), s));
            return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/exit")
    public ResponseEntity<Boolean> exit(@RequestHeader("X-Token") String token) {
        boolean delete = tokenService.delete(token);
        return new ResponseEntity<>(delete, HttpStatus.ACCEPTED);
    }

}
