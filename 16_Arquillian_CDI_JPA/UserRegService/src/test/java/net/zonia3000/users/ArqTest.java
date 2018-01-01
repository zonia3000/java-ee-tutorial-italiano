package net.zonia3000.users;

import java.io.File;
import javax.inject.Inject;
import net.zonia3000.foo.FooClass;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RunWith(Arquillian.class)
public class ArqTest {

    @Deployment
    public static WebArchive createDeployment() {

        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackages(false, "net.zonia3000.users")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsLibraries(getArchiveDependencies());

        return archive;
    }

    private static File[] getArchiveDependencies() {
        return Maven.resolver().loadPomFromFile("pom.xml")
                .importRuntimeDependencies().resolve().withTransitivity().asFile();
    }

    @Inject
    private Controller controller;

    @Test
    public void test() {
        User user = controller.addNewUser("pippo");

        assertNotNull(user);
        assertEquals(1, controller.getAllUsers().size());

        user = controller.addNewUser("pluto");
        assertNotNull(user);
        assertEquals(2, controller.getAllUsers().size());

        user = controller.addNewUser("pluto");
        assertNull(user);
        assertEquals(2, controller.getAllUsers().size());

        // Test using dependency
        assertEquals("foo!", FooClass.fooMethod());
    }
}
