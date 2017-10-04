package net.zonia3000.interceptors;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Decorator
public abstract class ControllaLungheEsecuzioni implements Executor {

    @Inject
    @Delegate
    private Executor executor;

    @Override
    public int execute(int parametro) {
        if(parametro > 5000) {
            throw new RuntimeException("Non è permesso ciclare più di 5000 volte!!!");
        }
        return executor.execute(parametro);
    }

}
