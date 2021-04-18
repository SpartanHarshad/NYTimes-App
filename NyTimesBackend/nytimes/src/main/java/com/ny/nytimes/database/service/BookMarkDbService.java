package com.ny.nytimes.database.service;

import com.ny.nytimes.database.entity.BookMarkEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookMarkDbService {

    public void insertBookMark(BookMarkEntity bookMarkEntity);

    public void removeBookMark(String id);

    public Iterable<BookMarkEntity> getAll(String email);

}
