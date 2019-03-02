package net.zonia3000.jpademo.executor;

import net.zonia3000.jpademo.JPAExecutor;
import net.zonia3000.jpademo.Libro;
import net.zonia3000.jpademo.Utente;

/**
 * CascadeType.REMOVE vs orphanRemoval.
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Example5 extends JPAExecutor {

    @Override
    public void execute() {

        Libro libro = new Libro("Isaac Asimov", "Io, Robot");
        
        Utente utente = new Utente("pippo");
        utente.getLibri().add(libro);
        persist(utente);
          
        utente.getLibri().clear();
        merge(utente);
        
        //remove(utente);
    }
}
