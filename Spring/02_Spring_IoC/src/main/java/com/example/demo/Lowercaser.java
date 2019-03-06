package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// L'annotazione Primary dice all'IoC di scegliere questa implementazione
// in caso di ambiguità (quando non c'è un Qualifier)
@Primary
@Component
public class Lowercaser implements StringTransformer {

    @Override
    public String transform(String input) {
        return input.toLowerCase();
    }
}
