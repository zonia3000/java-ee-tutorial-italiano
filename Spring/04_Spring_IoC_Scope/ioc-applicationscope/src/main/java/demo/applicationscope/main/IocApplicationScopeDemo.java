package demo.applicationscope.main;

import demo.applicationscope.mvc2.Config2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class IocApplicationScopeDemo {

    public static void main(String[] args) {
        SpringApplication.run(IocApplicationScopeDemo.class, args);
    }

    @Bean
    public ServletRegistrationBean mvc2() {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(Config2.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setApplicationContext(applicationContext);

        DispatcherServletRegistrationBean servletRegistrationBean = new DispatcherServletRegistrationBean(dispatcherServlet, "/mvc2/*");
        servletRegistrationBean.setName("mvc2");

        return servletRegistrationBean;
    }
}
