package com.ajex.ajexApp.controller;

import com.ajex.ajexApp.dto.Book;
import com.ajex.ajexApp.dto.serviceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    List<Book> bookstore = new ArrayList<>();


    @PostMapping("/saveBook")
    public ResponseEntity<Object> addBook (@RequestBody Book book) {
        bookstore.add(book);
        serviceResponse<Book> response = new serviceResponse<Book>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<Object> getAllBooks () {
        serviceResponse<List<Book>> response = new serviceResponse<>("success", bookstore);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }



}
