package com.example.test.controller;

import com.example.test.constants.Constants;
import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import com.example.test.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@Api("User controller")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/")
    @ApiOperation("Get all users from database")
    public Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap<>();

        map.put(Constants.USERS, userService.getAll());
        map.put(Constants.TOTAL, userService.getAll().size());
        map.put(Constants.SUCCESS, true);

        return map;
    }

    @PostMapping(value = "/")
    @ApiOperation("Add a specific user")
    public Map<String, Object> add(@RequestBody UserDto userDto){
        Map<String, Object> map = new HashMap<>();

        User user = userService.save(userDto);
        map.put(Constants.MESSAGE, user.getFirstName() + " is created successfully");
        map.put(Constants.SUCCESS, true);

        return map;
    }
}
