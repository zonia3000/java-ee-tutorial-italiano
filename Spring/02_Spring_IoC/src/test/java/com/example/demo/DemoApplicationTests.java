package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StringTransformer lowercaser;

    @Autowired
    @Qualifier("maiuscolatore")
    private StringTransformer uppercaser;

    @Autowired
    @Qualifier("reverser")
    private StringTransformer reverser;

    @Autowired
    private Bean1 bean1;

    @Autowired
    private Bean2 bean2;

    @Test
    public void contextLoads() {
        assertEquals("ciao", lowercaser.transform("CIAO"));
        assertEquals("CIAO", uppercaser.transform("ciao"));
        assertEquals("oaic", reverser.transform("ciao"));
        assertNotNull(bean1.getMessage());
        assertNotNull(bean2.getMessage());
    }
}
