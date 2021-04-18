package com.ny.nytimes.rest;

import com.ny.nytimes.database.entity.BookMarkEntity;
import com.ny.nytimes.database.service.BookMarkDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookmarkController {

    @Autowired
    BookMarkDbService bookMarkDbService;

    @PostMapping(path = "/insertBookMark",consumes = "application/json" , produces = "application/json")
    public void insertBookmark(@RequestBody BookMarkEntity bookMarkEntity) {
        bookMarkEntity.setId(bookMarkEntity.getTitle() + bookMarkEntity.getEmail());
        bookMarkDbService.insertBookMark(bookMarkEntity);
    }

    @GetMapping("/deleteBookMark/{id}")
    public void delBookMark(@PathVariable("id") String id) {
        bookMarkDbService.removeBookMark(id);
    }

    @GetMapping("/getAllBookMarks/{email}")
    public Iterable<BookMarkEntity> getAllBookMarks(@PathVariable("email") String email) {
        return bookMarkDbService.getAll(email);
    }


}
