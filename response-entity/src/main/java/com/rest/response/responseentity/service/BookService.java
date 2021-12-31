package com.rest.response.responseentity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.response.responseentity.entity.Book;



@Component
public class BookService {
	 private static List<Book> list = new ArrayList<>();
	  
     static {
         list.add(new Book(12, "Java Complete Reference ", "XYZ"));
         list.add(new Book(36, "Head First to Java", "ABC"));
         list.add(new Book(12963, "Thing in Java", "LMN"));
     }
  // get all books
     public List<Book> getAllBooks() {
    	 return list;
     }
     
     // get single book by id
     public Book getBookById(int id) {
         Book book = null;
         try {
             book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            
         } catch (Exception e) {
             e.printStackTrace();
         }
         return book;
     }
     
     
     //add book
     public Book addBook(Book b)
     {
    	 list.add(b);
    	 return b;
     }
// delete the book
	public void deleteBook(int bookId) {
		list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
	}
		// update the book
	    public void updateBook(Book book, int bookId) {
	         list = list.stream().map(b -> {
	             if (b.getId() == bookId) {
	                 b.setTitle(book.getTitle());
	                 b.setAuthor(book.getAuthor());
	             }
	             return b;
	         }).collect(Collectors.toList());
			
}
	    

}
