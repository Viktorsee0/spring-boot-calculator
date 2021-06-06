package com.example.springbootcalculator.dao;

import com.example.springbootcalculator.entity.calc.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OperationDao {
    private List<Operation> operations = new ArrayList<>();
    private long incId = 1;

    public Operation save(Operation operation){
        operation.setId(incId++);
        operations.add(operation);
        return operation;
    }

    public List<Operation> getByUserId(long userId){
        List<Operation> collect = operations.stream().filter(operation -> operation.getUserId() == userId).collect(Collectors.toList());
        System.out.println(operations);
        return collect;
    }
}
