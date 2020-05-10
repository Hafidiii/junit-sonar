package com.example.test.controller;

import com.example.test.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculate")
public class CalculateController {
    @Autowired
    private ICalculateService calculateService;

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public int sum() {
        return calculateService.addData() + 1;
    }
}
