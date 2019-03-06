package com.example.demo;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("jaxrs")
public class JerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void setUp() {
        register(CiaoController.class);
    }
}
