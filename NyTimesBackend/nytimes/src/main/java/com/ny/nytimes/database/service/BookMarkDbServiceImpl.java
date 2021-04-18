package com.ny.nytimes.database.service;

import com.ny.nytimes.database.dao.BookMarkDao;
import com.ny.nytimes.database.entity.BookMarkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMarkDbServiceImpl implements BookMarkDbService {

    @Autowired
    BookMarkDao bookMarkDao;

    @Override
    public void insertBookMark(BookMarkEntity bookMarkEntity) {
        bookMarkDao.save(bookMarkEntity);
    }

    @Override
    public void removeBookMark(String id) {
        bookMarkDao.deleteById(id);
    }

    @Override
    public Iterable<BookMarkEntity> getAll(String email) {
        return bookMarkDao.findByEmail(email);
    }
}
