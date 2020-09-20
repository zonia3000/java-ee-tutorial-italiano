package net.zonia3000.jdbc;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));

        /*return jdbcTemplate.query("SELECT * FROM book", (rs, index) -> {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            Book book = new Book();
            book.setId(id);
            book.setAuthor(author);
            book.setTitle(title);
            return book;
        });*/
    }

    @Transactional
    public Book addBook(Book book) {
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO book(author, title) VALUES(:author,:title)",
                new BeanPropertySqlParameterSource(book), kh, new String[]{"id"});
        int id = (int) kh.getKey();
        book.setId(id);

        //jdbcTemplate.getJdbcTemplate().execute("UPDATE xxxx");
        return book;
    }
}
