package net.zonia3000.jpademo2;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RequestScoped
public class PersistenceBean {

    @PersistenceContext
    private EntityManager em;

    public Utente getUtente() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.from(Utente.class);
        Query q = em.createQuery(cq);

        return (Utente) q.getResultList().get(0);
    }
}
