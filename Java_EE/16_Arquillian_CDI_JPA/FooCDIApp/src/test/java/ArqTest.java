
import javax.inject.Inject;
import net.zonia3000.foocdi.Uppercaser;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RunWith(Arquillian.class)
public class ArqTest {

    @Inject
    private Uppercaser uppercaser;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(false, "net.zonia3000.foocdi")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void test() {
        assertEquals("HELLO", uppercaser.getUppercase("hello"));
        assertEquals("FOO!", uppercaser.getFooUppercase());
    }
}
