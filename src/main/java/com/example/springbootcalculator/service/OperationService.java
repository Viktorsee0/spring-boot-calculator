package com.example.springbootcalculator.service;

import com.example.springbootcalculator.dao.OperationDao;
import com.example.springbootcalculator.entity.OperationDto;
import com.example.springbootcalculator.entity.calc.Action;
import com.example.springbootcalculator.entity.calc.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OperationService {

    @Autowired
    OperationDao operationDao;
    @Autowired
    Map<String, Action> map;

    public Operation save(OperationDto dto, long userId) {
       return operationDao.save(createOperation(dto, userId));
    }

    public List<Operation> getByUserId(long userId) {
        return operationDao.getByUserId(userId);
    }

    private Operation createOperation(OperationDto dto, long userId){
        Operation operation = new Operation();
        operation.setOperation(dto.getOperation());
        operation.setFNum(dto.getFirstNum());
        operation.setSNum(dto.getSecondNum());
        operation.setResult(map.get(dto.getOperation()).execute(operation.getFNum(), operation.getSNum()));
        operation.setUserId(userId);
        return operation;
    }
}
