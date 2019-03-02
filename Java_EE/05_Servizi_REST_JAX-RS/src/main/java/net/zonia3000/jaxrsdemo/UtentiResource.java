package net.zonia3000.jaxrsdemo;

import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Path("utenti")
public class UtentiResource {

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_XML)
    public Utente getXml(@PathParam("userId") int id) {
        Utente u = new Utente();
        u.setNome("pippo");
        return u;
    }

    @GET
    @Path("test")
    public String testPost(@FormParam("valore") String valore) {
        return "Il valore e': " + valore;
    }
}
