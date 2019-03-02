package net.zonia3000.jpademo.executor;

import net.zonia3000.jpademo.JPAExecutor;
import net.zonia3000.jpademo.Libro;
import net.zonia3000.jpademo.Utente;

/**
 * Quando non va bene CascadeType.ALL
 * 
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Example2 extends JPAExecutor {

    @Override
    public void execute() {

        Libro libro = new Libro("Isaac Asimov", "Io, Robot");
        persist(libro);
        
        Utente u1 = new Utente("pippo");
        Utente u2 = new Utente("pluto");
        
        u1.getLibri().add(libro);
        persist(u1);
        
        u2.getLibri().add(libro);
        persist(u2);
        
    }
}
