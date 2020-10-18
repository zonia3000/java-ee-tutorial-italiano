package net.zonia3000.cache;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookDAO dao;

    @GetMapping("/")
    public List<Book> getBooks() {
        return dao.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

        return dao.getBookById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());

//        Book book = dao.getBookById(id);
//        if (book == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(book);
    }

    @GetMapping("/search")
    public ResponseEntity<Book> getBookByTitle(@RequestParam("title") String title) {
        Book book = dao.getBookByTitle(title);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book = dao.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
        dao.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
