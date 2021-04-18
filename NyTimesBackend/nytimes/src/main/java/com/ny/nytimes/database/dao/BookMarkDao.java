package com.ny.nytimes.database.dao;

import com.ny.nytimes.database.entity.BookMarkEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkDao extends CrudRepository<BookMarkEntity, String> {

    public Iterable<BookMarkEntity> findByEmail(String email);

}
