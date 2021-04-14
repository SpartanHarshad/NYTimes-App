package com.nytimes.nytimes.service;

import com.nytimes.nytimes.entity.HomeEntity;
import com.nytimes.nytimes.repository.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsDBServiceImpl implements NewsDBService {

    @Autowired
    private HomeDao homeDao;

    @Override
    public Iterable<HomeEntity> getByCategory(String category) {
        return homeDao.findByCategory(category);
    }
}
