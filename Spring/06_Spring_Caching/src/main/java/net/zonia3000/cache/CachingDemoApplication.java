package net.zonia3000.cache;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
@EnableCaching
public class CachingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachingDemoApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("spring_demo")
                .addScript("classpath:sql/db-init.sql")
                .build();
    }
}
