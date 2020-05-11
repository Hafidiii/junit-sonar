package com.example.test.service;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User save(UserDto userDto);
}
