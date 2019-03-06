package com.example.demo;

/**
 * Questo bean non è annotato con @Component perché è definito nella classe
 * Config.
 */
public class Bean1 {

    public String getMessage() {
        return "Ciao da Bean1";
    }
}
