package net.zonia3000.cdidemo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path("info")
public class InfoResource {

    @Inject
    private ApplicationData appData;

    @GET
    public String getInfo() {
        return appData.getInfo();
    }
}
