package net.zonia3000.jdbc;

import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class BookDAOTest {

    private BookDAO dao;

    @BeforeEach
    public void init() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("spring_demo;MODE=PostgreSQL")
                .addScript("classpath:sql/db-init.sql")
                .build();

        dao = new BookDAO(dataSource);
    }

    @Test
    public void testAddBook() {

        Book book = new Book();
        book.setAuthor("test_author");
        book.setTitle("test_title");

        book = dao.addBook(book);

        assertEquals(1, book.getId());
    }
}
