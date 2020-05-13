package com.example.test.controller;

import com.example.test.service.IMathUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/math")
@Api("Math Controller")
public class MathController {

    @Autowired
    private IMathUtils mathUtils;

    @GetMapping(value = "/add")
    @ApiOperation("Add operation method")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return mathUtils.add(a, b);
    }

    @GetMapping(value = "/multiply")
    @ApiOperation("multiply operation method")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return mathUtils.multiply(a, b);
    }

    @GetMapping(value = "/divide")
    @ApiOperation("divide operation method")
    public double divide(@RequestParam int a, @RequestParam int b) {
        return mathUtils.divide(a, b);
    }
}
