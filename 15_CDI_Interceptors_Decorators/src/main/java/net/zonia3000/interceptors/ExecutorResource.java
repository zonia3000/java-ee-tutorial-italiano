package net.zonia3000.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RequestScoped
@Path("execute")
public class ExecutorResource {

    @Inject
    private SommaRandomExecutor executor;

    @GET
    @Path("{parametro}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("parametro") int parametro) {
        return "Risultato = " + executor.execute(parametro);
    }
}
