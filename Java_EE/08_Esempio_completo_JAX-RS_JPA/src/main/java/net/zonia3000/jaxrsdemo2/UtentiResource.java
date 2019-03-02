package net.zonia3000.jaxrsdemo2;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RequestScoped
@Path("utenti")
public class UtentiResource {

    @PersistenceContext(unitName = "demo_pu")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Utente> getXml() {
        Query q = em.createNamedQuery("Utente.findAll", Utente.class);
        return q.getResultList();
    }

    @POST
    @Transactional
    public void aggiungiUtente(@FormParam("username") String username, @FormParam("email") String email) {
        Utente u = new Utente();
        u.setUsername(username);
        u.setEmail(email);
        em.persist(u);
    }
}
