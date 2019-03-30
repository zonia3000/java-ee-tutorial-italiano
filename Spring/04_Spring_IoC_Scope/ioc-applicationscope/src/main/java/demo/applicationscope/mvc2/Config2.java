package demo.applicationscope.mvc2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"demo.applicationscope.mvc2", "demo.applicationscope.main.beans"})
@EnableWebMvc
public class Config2 {

}
