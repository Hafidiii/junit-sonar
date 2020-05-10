package com.example.test.service.impl;

import com.example.test.dao.IDataDao;
import com.example.test.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {

    @Autowired
    IDataDao dataDao;

    @Override
    public int addData() {
        int sum = 0;

        for (int item :
                dataDao.getData()) {
            sum += item;
        }
        return sum;
    }

}
