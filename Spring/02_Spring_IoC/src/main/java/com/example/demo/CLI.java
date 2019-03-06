package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLI implements CommandLineRunner {

    // Recupera un Lowercaser grazie ad @Primary
    @Autowired
    private StringTransformer transformer0;

    @Autowired
    @Qualifier("maiuscolatore")
    private StringTransformer transformer1;

    @Autowired
    @Qualifier("reverser")
    private StringTransformer transformer2;

    @Autowired
    private Bean1 bean1;

    @Autowired
    private Bean2 bean2;

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            System.out.println(transformer0.transform(args[0]));
            System.out.println(transformer1.transform(args[0]));
            System.out.println(transformer2.transform(args[0]));
            System.out.println(bean1.getMessage());
            System.out.println(bean2.getMessage());
        }
    }
}
