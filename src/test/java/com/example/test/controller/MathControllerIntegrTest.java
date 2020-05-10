package com.example.test.controller;

import com.example.test.TestApplication;
import com.example.test.service.IMathUtils;
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
@DisplayName("MathController Test Class")
class MathControllerIntegrTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Add Test")
    void testAdd(TestReporter testReporter, TestInfo testInfo) throws Exception {
        int a = 12;
        int b = 12;

        MvcResult result = mockMvc.perform(get("/math/add?a=" + a + "&b=" + b)).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ----> " + result.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Multiply Test")
    void testMultiply(TestReporter testReporter, TestInfo testInfo) throws Exception {
        int a = 2;
        int b = 10;

        MvcResult result = mockMvc.perform(get("/math/multiply?a=" + a + "&b=" + b)).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ----> " + result.getResponse().getContentAsString());


    }

    @Test
    @DisplayName("Divide Test")
    void testDivide(TestReporter testReporter, TestInfo testInfo) throws Exception {
        int a = 10;
        int b = 2;

        MvcResult result = mockMvc.perform(get("/math/divide?a=" + a + "&b=" + b)).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(testInfo.getDisplayName() + " ----> " + result.getResponse().getContentAsString());

    }
}