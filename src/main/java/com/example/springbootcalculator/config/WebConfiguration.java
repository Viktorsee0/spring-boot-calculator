package com.example.springbootcalculator.config;

import com.example.springbootcalculator.entity.calc.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.nio.channels.AcceptPendingException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.example.springbootcalculator")
public class WebConfiguration {
    @Bean
    public Map<String, Action> getMap(Sum sum, Sub sub, Mul mul, Div div){
        Map<String, Action> map = new HashMap<>();
        map.put("sum", sum);
        map.put("sub", sub);
        map.put("mul", mul);
        map.put("div", div);
        return map;
    }
}
