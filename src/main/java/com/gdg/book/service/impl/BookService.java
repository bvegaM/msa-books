package com.gdg.book.service.impl;

import com.gdg.book.domain.Book;
import com.gdg.book.repository.BookRepository;
import com.gdg.book.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

  private final BookRepository bookRepository;

  @Override
  public Book findById(String id) {
    return bookRepository.findById(id).orElse(null);
  }

  @Override
  public Book save(Book book) {
    return bookRepository.save(book);
  }
}