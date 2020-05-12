package com.example.test.controller;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import com.example.test.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@DisplayName("UNIT TEST :: UserController")
class mathUtils {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private IUserService userService;

    @Test
    @DisplayName("Get all users test case")
    void getAll(TestReporter testReporter, TestInfo testInfo) throws Exception {
        List<User> users = Arrays.asList(new User("guess", "Bill"), new User("jack", "biko"), new User("Firbo", "deep"));
        when(userService.getAll()).thenReturn(users);

        MvcResult result = mockMvc.perform(get("/users/")).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ---> " + result.getResponse().getContentAsString());

        verify(userService, atMost(2)).getAll();
    }

    @Test
    @DisplayName("Save an user test case")
    void add(TestReporter testReporter, TestInfo testInfo) throws Exception {

        User user = new User(22L, "guess", "Bill");
        UserDto userDto = new UserDto(user);

        when(userService.save(userDto)).thenReturn(user);

        MvcResult result = mockMvc.perform(post("/users/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ---> " + result.getResponse().getContentAsString());

        verify(userService).save(userDto);
    }
}