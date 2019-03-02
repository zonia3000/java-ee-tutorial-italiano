package net.zonia3000.jaxrsdemo;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(net.zonia3000.jaxrsdemo.UtentiResource.class);
    }

}
