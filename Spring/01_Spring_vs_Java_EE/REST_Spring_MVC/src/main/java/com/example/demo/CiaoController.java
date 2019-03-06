package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CiaoController {
    
    @GetMapping("/")
    public String saluta() {
        return "Ciao da Spring MVC";
    }
}
