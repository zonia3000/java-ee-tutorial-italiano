
package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("maiuscolatore")
@Component
public class Uppercaser implements StringTransformer{

    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }

}
