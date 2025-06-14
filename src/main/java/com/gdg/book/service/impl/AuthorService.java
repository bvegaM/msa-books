package com.gdg.book.service.impl;

import com.gdg.book.domain.Author;
import com.gdg.book.repository.AuthorRepository;
import com.gdg.book.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

  private final AuthorRepository authorRepository;

  @Override
  public Author findById(String id) {
    return authorRepository.findById(id).orElse(null);
  }

  @Override
  public Author save(Author author) {
    return authorRepository.save(author);
  }
}
