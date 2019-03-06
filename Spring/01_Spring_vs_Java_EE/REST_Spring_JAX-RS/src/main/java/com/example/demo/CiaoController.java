package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class CiaoController {

    @GET
    public String saluta() {
        return "Ciao da JAX-RS";
    }
}
