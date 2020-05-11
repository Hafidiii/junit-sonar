package com.example.test.service;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import com.example.test.repository.UserRepository;
import com.example.test.service.impl.UserService;
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


    @Test
    void getAll() {

        List<User> users = Arrays.asList(new User("guess", "Bill"), new User("jack", "biko"), new User("Firbo", "deep"));
        when(userRepository.findAll()).thenReturn(users);
        assertArrayEquals(userService.getAll().toArray(), users.toArray());
        verify(userRepository).findAll();
    }

    @Test
    void save() {
        User expectedUser = new User("john","jack");

        when(userRepository.save(expectedUser)).thenReturn(new User(15L,"john","jack"));

        User actualUser = userService.save(new UserDto(expectedUser));

        assertEquals(new User(15L,"john","jack"), actualUser);

        //make sure that save method is called only once.
        //verify(userRepository, atLeast(2)).save(expectedUser) : check if save method is called at least 2 times
        verify(userRepository).save(expectedUser);
    }
}