package com.example.springbootcalculator.entity.calc;

import org.springframework.stereotype.Component;

@Component
public class Sum implements Action {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
