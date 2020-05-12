package com.example.test.controller;

import com.example.test.service.IMathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    @Autowired
    private IMathUtils mathUtils;

    @GetMapping(value = "/add")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return mathUtils.add(a, b);
    }

    @GetMapping(value = "/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return mathUtils.multiply(a, b);
    }

    @GetMapping(value = "/divide")
    public double divide(@RequestParam int a, @RequestParam int b) {
        return mathUtils.divide(a, b);
    }
}
