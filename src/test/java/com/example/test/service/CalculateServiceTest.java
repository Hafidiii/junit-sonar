package com.example.test.service;

import com.example.test.dao.IDataDao;
import com.example.test.dao.impl.DataDao;
import com.example.test.service.impl.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;


@RunWith(MockitoJUnitRunner.class)
@DisplayName("CALCULATE SERVICE TEST CLASS")
class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Mock
    IDataDao dataDao;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        when(dataDao.getData()).thenReturn(new int[]{5,6,5});
    }

    @Test
    @DisplayName("add data test case")
    void testAddData() {
        assertEquals(16, calculateService.addData());
    }
}