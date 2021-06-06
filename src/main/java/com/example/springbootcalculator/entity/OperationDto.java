package com.example.springbootcalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {
    private double firstNum;
    private double secondNum;
    private String operation;
}

