package com.example.test.dao.impl;

import com.example.test.dao.IDataDao;
import org.springframework.stereotype.Service;

@Service
public class DataDao implements IDataDao {

    @Override
    public int[] getData() {
        return new int[]{1, 2, 3};
    }
}
