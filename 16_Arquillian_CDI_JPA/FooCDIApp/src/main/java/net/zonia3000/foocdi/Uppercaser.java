package net.zonia3000.foocdi;

import javax.enterprise.context.ApplicationScoped;
import net.zonia3000.foo.FooClass;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@ApplicationScoped
public class Uppercaser {

    public String getUppercase(String input) {
        return input.toUpperCase();
    }

    public String getFooUppercase() {
        return FooClass.fooMethod().toUpperCase();
    }
}
