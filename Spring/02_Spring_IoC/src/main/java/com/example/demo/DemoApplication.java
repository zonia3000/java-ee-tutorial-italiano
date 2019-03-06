package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext appCtx = SpringApplication.run(DemoApplication.class, args);
        
        // Il metodo run di SpringApplication restituisce un ApplicationContext.
        // L'ApplicationContext è la classe che di fatto gestisce i bean.
        // Di solito non si ottengono i bean chiamando direttamente questa classe,
        // ma sapere che esiste è utile per capire il funzionamento interno dell'IoC:
        // --------------------------------------------------------
        // Uppercaser uppercaser = appCtx.getBean(Uppercaser.class);
        // System.out.println(uppercaser.transform("demo"));
    }
}
