package com.nytimes.nytimes.repository;

import com.nytimes.nytimes.entity.HomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeDao extends CrudRepository<HomeEntity, Integer> {
    public Iterable<HomeEntity> findByCategory(String category);
}
