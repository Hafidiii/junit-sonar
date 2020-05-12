package com.example.test.service;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import com.example.test.mapper.UserMapper;
import com.example.test.repository.UserRepository;
import com.example.test.service.impl.UserService;
import fr.xebia.extras.selma.Selma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    private UserRepository userRepository;

    private UserMapper mapper;

    @BeforeEach
    void setup(){
        mapper= Selma.getMapper(UserMapper.class);
    }


    @Test
    void getAll() {

        List<User> users = Arrays.asList(new User("guess", "Bill"), new User("jack", "biko"), new User("Firbo", "deep"));
        when(userRepository.findAll()).thenReturn(users);
        assertArrayEquals(userService.getAll().toArray(), users.toArray());
        verify(userRepository).findAll();
    }

    @Test
    void save() {
        User givenUser = new User("john","jack");
        User actualUser = new User(15L, "john","jack");

        when(userRepository.save(givenUser)).thenReturn(actualUser);

        User expectedUser = userService.save(mapper.asUserDto(givenUser));

        assertEquals(actualUser, expectedUser);

        //make sure that save method is called only once.
        //verify(userRepository, atLeast(2)).save(expectedUser) : check if save method is called at least 2 times
        verify(userRepository).save(givenUser);
    }
}