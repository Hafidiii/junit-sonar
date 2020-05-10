package com.example.test.controller;

import com.example.test.service.IMathUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MathController.class)
class MathControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IMathUtils mathUtils;


    @Test
    void testAdd(TestReporter testReporter) throws Exception {
        int a = 12;
        int b = 12;
        given(mathUtils.add(a,b)).willReturn(24);

        MvcResult result = mockMvc.perform(get("/math/add?a=" + a + "&b=" + b)).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(result.getResponse().getContentAsString());

        verify(mathUtils).add(a,b);
    }

    @Test
    void testMultiply(TestReporter testReporter) throws Exception {
        int a = 2;
        int b = 10;
        given(mathUtils.multiply(a,b)).willReturn(20);

        MvcResult result = mockMvc.perform(get("/math/multiply?a=" + a + "&b=" + b)).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(result.getResponse().getContentAsString());

        verify(mathUtils).multiply(a,b);
    }

    @Test
    void testDivide(TestReporter testReporter) throws Exception {
        int a = 10;
        int b = 2;
        given(mathUtils.divide(a,b)).willReturn(5.0);

        MvcResult result = mockMvc.perform(get("/math/divide?a=" + a + "&b=" + b)).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(result.getResponse().getContentAsString());

        verify(mathUtils).divide(a,b);
    }
}