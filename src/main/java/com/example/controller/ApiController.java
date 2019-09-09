package com.example.controller;

import com.example.Service.LibraryService;
import com.example.view.BookIsbn;
import com.example.view.RatingBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    LibraryService libraryService;

    //test only
    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping(path = "/book/{isbn}", produces = "application/json;charset=UTF-8")
    public BookIsbn bookByIsbn(@PathVariable String isbn){
        BookIsbn bookIsbn = libraryService.getBookByIsbn(isbn);
        if(null != bookIsbn){
            return bookIsbn;
        }else{
            throw new ResourceNotFoundException();
        }
    }

    @GetMapping(path = "/category/{category}/books", produces = "application/json;charset=UTF-8")
    public List<BookIsbn> booksByCategory(@PathVariable String category){
        return libraryService.getBooksByCategory(category);
    }

    @GetMapping(path = "/rating", produces = "application/json;charset=UTF-8")
    public List<RatingBook> getRating(){
        return libraryService.getRatingBook();
    }
}
