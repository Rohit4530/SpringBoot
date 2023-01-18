package com.book.service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
   @Autowired
    BookRepository repo;
    public List<Book> getBooks(){
        return repo.findAll();
    }

    public Book addBook(Book book) {
      return  repo.save(book);
    }

    public void deleteBook(Integer Id) {
        repo.deleteById(Id);
    }
}
