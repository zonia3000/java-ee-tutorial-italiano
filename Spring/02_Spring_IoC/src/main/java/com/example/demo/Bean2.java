package com.example.demo;

/**
 * Questo bean è definito tramite XML (src/main/resources/config.xml).
 */
public class Bean2 {

    private final String message;

    public Bean2(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
