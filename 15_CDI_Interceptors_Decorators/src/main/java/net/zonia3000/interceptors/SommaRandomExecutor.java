package net.zonia3000.interceptors;

import java.security.SecureRandom;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Dependent
@Profiled
public class SommaRandomExecutor implements Executor {

    @Override
    public int execute(int parametro) {
        double somma = 0;

        for (int i = 0; i < parametro; i++) {
            for (int j = 0; j < 100; j++) {
                somma += new SecureRandom().nextDouble();
            }
        }

        return (int) somma;
    }
}
