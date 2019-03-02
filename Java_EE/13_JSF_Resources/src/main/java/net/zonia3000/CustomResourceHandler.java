package net.zonia3000;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.faces.application.ProjectStage;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.application.ResourceWrapper;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class CustomResourceHandler extends ResourceHandlerWrapper {

    private final ResourceHandler originalResourceHandler;
    private final boolean addMin;
    private final String version;

    public CustomResourceHandler(ResourceHandler originalResourceHandler) {
        this.originalResourceHandler = originalResourceHandler;
        FacesContext ctx = FacesContext.getCurrentInstance();
        addMin = ctx.getApplication().getProjectStage() == ProjectStage.Production;

        try (InputStream is = CustomResourceHandler.class.getClassLoader().getResourceAsStream("version.txt")) {
            version = new Scanner(is).useDelimiter("\\A").next();
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public ResourceHandler getWrapped() {
        return originalResourceHandler;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {
        final Resource resource = super.createResource(resourceName, libraryName);

        if (resource == null) {
            return null;
        }

        return new ResourceWrapper() {

            @Override
            public String getRequestPath() {
                String path = super.getRequestPath();
                path += "&v=" + version;
                if (addMin) {
                    path = path.replace(".js", ".min.js");
                    path = path.replace(".css", ".min.css");
                }
                return path;
            }

            @Override
            public Resource getWrapped() {
                return resource;
            }
        };
    }
}
