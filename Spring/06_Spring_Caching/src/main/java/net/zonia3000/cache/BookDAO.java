package net.zonia3000.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "book")
public class BookDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Cacheable
    public Optional<Book> getBookById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return Optional.ofNullable(jdbcTemplate.query("SELECT * FROM book WHERE id = :id", params, getFirstOrNull()));
    }

    @Cacheable(cacheNames = "bookByTitle", unless = "#result == null")
    public Book getBookByTitle(String title) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        return jdbcTemplate.query("SELECT * FROM book WHERE title = :title", params, getFirstOrNull());
    }

    private ResultSetExtractor<Book> getFirstOrNull() {
        BeanPropertyRowMapper<Book> mapper = new BeanPropertyRowMapper<>(Book.class);
        return rs -> {
            if (rs.next()) {
                return mapper.mapRow(rs, 0);
            }
            return null;
        };
    }

    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    @Caching(put = {
        @CachePut(key = "#book.id"),
        @CachePut(cacheNames = "bookByTitle", key = "#book.title")
    })
    public Book addBook(Book book) {
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO book(author, title) VALUES(:author, :title)",
                new BeanPropertySqlParameterSource(book), kh, new String[]{"id"});
        int id = (int) kh.getKey();
        book.setId(id);
        return book;
    }

    @Caching(evict = {
        @CacheEvict,
        @CacheEvict(cacheNames = "bookByTitle", allEntries = true)
    })
    public void deleteBook(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("DELETE FROM book WHERE id = :id", params);
    }
}
