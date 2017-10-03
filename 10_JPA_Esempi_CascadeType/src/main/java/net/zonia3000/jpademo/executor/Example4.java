package net.zonia3000.jpademo.executor;

import javax.persistence.EntityManager;
import net.zonia3000.jpademo.JPAExecutor;
import net.zonia3000.jpademo.Libro;
import net.zonia3000.jpademo.Utente;

/**
 * Cascade.DETACH
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Example4 extends JPAExecutor {

    @Override
    public void execute() {

        Libro libro = new Libro("Isaac Asimov", "Io, Robot");

        Utente utente = new Utente("pippo");
        utente.getLibri().add(libro);
        persist(utente);

        EntityManager em = createEntityManager();

        System.out.println("1: " + em.contains(utente));

        utente = em.merge(utente);
        libro = utente.getLibri().get(0);

        System.out.println("2: " + em.contains(utente));
        System.out.println("3: " + em.contains(libro));

        em.detach(utente);

        System.out.println("4: " + em.contains(utente));
        System.out.println("5: " + em.contains(libro));

        em.close();
    }
}
