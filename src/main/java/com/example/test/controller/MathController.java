package com.example.test.controller;

import com.example.test.service.IMathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    @Autowired
    private IMathUtils mathUtils;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public int sum(@RequestParam int a, @RequestParam int b) {
        return mathUtils.add(a, b);
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return mathUtils.multiply(a, b);
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public double divide(@RequestParam int a, @RequestParam int b) {
        return mathUtils.divide(a, b);
    }
}
