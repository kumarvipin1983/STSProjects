package com.spring.library.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.spring.library.interfaces.BookService;
import com.spring.library.model.Book;

@Service
public class InMemoryBookService implements BookService {

	private final Map<String, Book> books = new ConcurrentHashMap<>();

	@Override
	public Iterable<Book> findAll() {
		return books.values();
	}

	@Override
	public Book create(Book book) {
		return books.put(book.getIsbn(), book);
	}

	@Override
	public Optional<Book> find(String isbn) {
		return Optional.ofNullable(books.get(isbn));
	}

}
