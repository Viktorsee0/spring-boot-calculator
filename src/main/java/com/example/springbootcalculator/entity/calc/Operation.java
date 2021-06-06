package com.example.springbootcalculator.entity.calc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private long id;
    private long userId;
    private double fNum;
    private double sNum;
    private String operation;
    private double result;
}
