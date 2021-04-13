package com.nytimes.nytimes.rest;

import com.nytimes.nytimes.entity.HomeEntity;
import com.nytimes.nytimes.service.NewsDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsRestController {

    @Autowired
    private NewsDBService newsDBService;

    @RequestMapping("category/{category}")
    public Iterable<HomeEntity> getCategory(@PathVariable(name = "category") String category) {
        return newsDBService.getByCategory(category);
    }

}
