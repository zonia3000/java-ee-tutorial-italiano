package net.zonia3000.jaxbdemo;

import java.io.StringWriter;
import javax.xml.bind.JAXB;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Main {

    public static void main(String[] args) {

        Utente utente = new Utente();
        utente.setNome("pippo");
        utente.setEmail("pippo@pippo.com");

        Libro libro1 = new Libro();
        libro1.setAutore("Isaac Asimov");
        libro1.setTitolo("Io, Robot");
        utente.getLibri().add(libro1);

        Libro libro2 = new Libro();
        libro2.setAutore("Michael Crichton");
        libro2.setTitolo("Preda");
        utente.getLibri().add(libro2);

        StringWriter sw = new StringWriter();

        JAXB.marshal(utente, sw);

        System.out.println(sw.toString());
    }
}
