package com.nytimes.nytimes.service;

import com.nytimes.nytimes.entity.HomeEntity;
import org.springframework.stereotype.Service;

@Service
public interface NewsDBService {

    public Iterable<HomeEntity> getByCategory(String category);

}
