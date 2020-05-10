package com.example.test.controller;

import com.example.test.TestApplication;
import com.example.test.service.ICalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = TestApplication.class)
@AutoConfigureMockMvc
class CalculateControllerIntegrTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSum(TestReporter testReporter) throws Exception {

        MvcResult result = mockMvc.perform(get("/calculate/sum")).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(result.getResponse().getContentAsString());

    }
}