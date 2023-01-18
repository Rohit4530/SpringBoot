package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    BookService service;

@GetMapping("/books")
    public ResponseEntity<List<Book>> get(){
    List<Book>books=service.getBooks();
    return  new ResponseEntity<>(books,HttpStatus.OK);
   }
   @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Integer id){
   Optional<Book> book= service.getBooks().stream().filter(e->
        e.getId().equals(id)
     ).findFirst();
    if(book.isPresent()){
        return new ResponseEntity<>(book,HttpStatus.OK);
    }else {
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   }
   @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
     Book newBook= service.addBook(book);
     return new ResponseEntity<>(newBook, HttpStatus.CREATED);
   }
   @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer Id){
      service.deleteBook(Id);
      return new ResponseEntity<>(HttpStatus.OK);
   }
   @PutMapping("/book/update")
   public ResponseEntity<Book> updateBook(@RequestBody Book book){
       Book newBook= service.addBook(book);
       return new ResponseEntity<>(newBook, HttpStatus.CREATED);
   }


}
