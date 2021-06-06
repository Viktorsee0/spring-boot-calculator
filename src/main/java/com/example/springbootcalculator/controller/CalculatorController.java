package com.example.springbootcalculator.controller;

import com.example.springbootcalculator.entity.OperationDto;
import com.example.springbootcalculator.entity.Token;
import com.example.springbootcalculator.entity.calc.Action;
import com.example.springbootcalculator.entity.calc.Operation;
import com.example.springbootcalculator.entity.calc.User;
import com.example.springbootcalculator.service.OperationService;
import com.example.springbootcalculator.service.TokenService;
import com.example.springbootcalculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class CalculatorController {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    @Autowired
    OperationService operationService;

    @Autowired
    Map<String, Action> map;


    @PostMapping("/calc")
    public ResponseEntity<Operation> calc(@RequestBody OperationDto operationDto, @RequestHeader("X-Token") String token) {

        Token token1 = tokenService.getToken(token);
        if (token1 != null) {
            Operation saveOperation = operationService.save(operationDto, token1.getUserId());
            return new ResponseEntity<>(saveOperation, HttpStatus.ACCEPTED);

        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/history")
    public ResponseEntity<List<Operation>> history(@RequestHeader("X-Token") String token) {

        Token token1 = tokenService.getToken(token);
        if (token1 != null) {
            List<Operation> byUserId = operationService.getByUserId(token1.getUserId());
            return new ResponseEntity<>(byUserId, HttpStatus.ACCEPTED);

        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
