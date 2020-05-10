package com.example.test.controller;

import com.example.test.service.ICalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculateController.class)
class CalculateControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICalculateService calculateService;

    @Test
    void testSum(TestReporter testReporter) throws Exception {
        given(calculateService.addData()).willReturn(88);

        MvcResult result = mockMvc.perform(get("/calculate/sum")).andExpect(status().isOk()).andReturn();
        testReporter.publishEntry(result.getResponse().getContentAsString());

        verify(calculateService).addData();
    }
}