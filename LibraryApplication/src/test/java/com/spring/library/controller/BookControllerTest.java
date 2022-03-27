package com.spring.library.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.library.interfaces.BookService;
import com.spring.library.model.Book;

@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	public void shouldReturnListOfBooks() throws Exception {
		List<Book> booklist = new ArrayList<>();
		booklist.add(new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long"));
		booklist.add(new Book("321", "Pro Spring MVC", "Marten Deinum", "Colin Yates"));
		when(bookService.findAll()).thenReturn(booklist);

		this.mockMvc.perform(get("/books")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturn404WhenBookNotFound() throws Exception {
		when(bookService.find("4527")).thenReturn(Optional.empty());
		this.mockMvc.perform(get("/books/4527")).andExpect(status().isNotFound());
	}
}
