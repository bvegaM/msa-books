package com.gdg.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

  private String id;
  private String name;
  private String description;
  private Integer yearPublication;
  private List<Author> listOfAuthors;
}