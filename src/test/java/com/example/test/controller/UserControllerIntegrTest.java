package com.example.test.controller;

import com.example.test.TestApplication;
import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import com.example.test.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestApplication.class
)
@AutoConfigureMockMvc
@DisplayName("INTEGRATION TEST :: UserController")
class UserControllerIntegrTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Get all users test case")
    void getAll(TestReporter testReporter, TestInfo testInfo) throws Exception {

        MvcResult result = mockMvc.perform(get("/users/")).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ---> " + result.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Save an user test case")
    void add(TestReporter testReporter, TestInfo testInfo) throws Exception {

        UserDto userDto = new UserDto("guess", "guess");

        MvcResult result = mockMvc.perform(post("/users/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ---> " + result.getResponse().getContentAsString());

    }
}