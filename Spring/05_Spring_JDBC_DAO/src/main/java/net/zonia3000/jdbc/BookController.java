package net.zonia3000.jdbc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookDAO dao;
    
    @GetMapping("/")
    public List<Book> getBooks() {
        return dao.getBooks();
    }
    
    @PostMapping("/")
    public Book addBook(@RequestBody Book book) {
        return dao.addBook(book);
    }
}
