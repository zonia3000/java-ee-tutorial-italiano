package net.zonia3000.jpademo3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_pu");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Indirizzo i1 = new Indirizzo();
        i1.setVia("via Roma");
        i1.setCitta("Trieste");
        em.persist(i1);
        
        Indirizzo i2 = new Indirizzo();
        i2.setVia("via Roma");
        i2.setCitta("Udine");
        em.persist(i2);
        
        Utente u = new Utente("pippo");
        em.persist(u);
        
        u.getIndirizzi().add(i1);
        u.getIndirizzi().add(i2);
        em.merge(u);
        
        em.getTransaction().commit();
        
        em.refresh(i1);
        em.refresh(i2);
        
        System.out.println(i1.getUtente().getUsername());
        System.out.println(i2.getUtente().getUsername());
        
        em.close();
        emf.close();
    }
    
}
