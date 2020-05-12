package com.example.test.service.impl;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import com.example.test.mapper.UserMapper;
import com.example.test.repository.UserRepository;
import com.example.test.service.IUserService;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    private UserMapper mapper;

    public UserService() {
        this.mapper = Selma.getMapper(UserMapper.class);
    }

    @Override
    public User save(UserDto userDto) {
        return userRepository.save(mapper.asUser(userDto));
    }


}
