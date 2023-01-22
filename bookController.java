package com.example.book.controller;

import com.example.book.model.Book;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookController {


    HashMap<Integer, Book> bookHashMap = new HashMap<Integer, Book>();

  // insert book- post - request body(book)
  @PostMapping("/insertBook")
  public Book insertBook(@RequestBody Book book){
    bookHashMap.put(book.getId(),book);
    return bookHashMap.put(book.getId(),book);
  }
    // updateBook - put - requestbody (book)
  @PutMapping("/updateBook")
  public Book updateBook(@RequestBody Book book){
    bookHashMap.put(book.getId(),book);
    return bookHashMap.get(book.getId());
  }

    // deleteBook -delete - path variable(id)
  @DeleteMapping("/deleteBook/{id}")
  public String deleteBook(@PathVariable("id") int Id){
    bookHashMap.remove(Id);
    return "book deleted successfully";
  }
    // getBookDetails - Get -pathvariable(id)
  @GetMapping("/book/{id}")
  public Book getBookDetails(@PathVariable("id") int Id){
    return bookHashMap.get(Id);
  }
    // getAllBooks - Get- Return Book List
  @GetMapping("/books")
  public List<Book> getBooks(){
    return bookHashMap.values().stream().collect(Collectors.toList());
  }

  @PatchMapping("/updateBook/{id}")
  public Book updateBook(@RequestBody Book book,@PathVariable("id") int Id){
    bookHashMap.put(book.getId(),book);
    return bookHashMap.get(book.getId());
  }
}
