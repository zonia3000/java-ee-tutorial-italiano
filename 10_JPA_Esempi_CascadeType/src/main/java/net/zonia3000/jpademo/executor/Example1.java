package net.zonia3000.jpademo.executor;

import net.zonia3000.jpademo.JPAExecutor;
import net.zonia3000.jpademo.Libro;
import net.zonia3000.jpademo.Utente;

/**
 * Lista libri CascadeType.PERSIST.
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Example1 extends JPAExecutor {

    @Override
    public void execute() {

        Utente utente = new Utente("pippo");
        
        Libro libro = new Libro("Isaac Asimov", "Io, Robot");
        utente.getLibri().add(libro);
        persist(utente);
    }

}
