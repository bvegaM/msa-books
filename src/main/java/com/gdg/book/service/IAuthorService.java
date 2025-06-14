package com.gdg.book.service;

import com.gdg.book.domain.Author;

public interface IAuthorService {

  Author findById(String id);

  Author save(Author author);
}
