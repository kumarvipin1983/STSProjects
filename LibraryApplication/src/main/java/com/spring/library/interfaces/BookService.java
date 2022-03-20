package com.spring.library.interfaces;

import java.util.Optional;

import com.spring.library.model.Book;

public interface BookService {
	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
