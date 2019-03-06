package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("reverser")
@Component
public class Reverser implements StringTransformer {

    @Override
    public String transform(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
