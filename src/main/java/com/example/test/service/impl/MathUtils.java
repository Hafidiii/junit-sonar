package com.example.test.service.impl;

import com.example.test.service.IMathUtils;
import org.springframework.stereotype.Service;

@Service
public class MathUtils implements IMathUtils {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public double divide(int a, int b) {
        return a / (double) b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }


}
