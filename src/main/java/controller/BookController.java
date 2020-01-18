package controller;

import model.Book;
import service.BookService;

import java.util.List;

public class BookController {

    BookService bookService= new BookService();

    public void insert(Book book){
        bookService.insert(book);
    }

    public Book searchById(int id) {
        return bookService.searchById(id);
    }

    public Book searchByTitle(String bookTitle) {
        return bookService.searchByTitle(bookTitle);
    }

    public List<Book> findAll(){
        return bookService.findAll();
    }

    public void update(Book book){
        bookService.update(book);
    }

    public void deleteById(int id){
        bookService.deleteById(id);
    }

    public void deleteByUsername(String title){
        bookService.deleteByTitle(title);
    }
}
