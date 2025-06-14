package com.gdg.book.service;

import com.gdg.book.domain.Book;

public interface IBookService {

  Book findById(String id);

  Book save(Book book);
}