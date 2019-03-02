
import javax.inject.Inject;
import net.zonia3000.foocdi.Uppercaser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class SadTest {

    @Inject
    private Uppercaser uppercaser;

    @Test
    public void test() {
        assertEquals("HELLO", uppercaser.getUppercase("hello"));
        assertEquals("FOO!", uppercaser.getFooUppercase());
    }
}
