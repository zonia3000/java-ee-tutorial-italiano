package net.zonia3000.producers1;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@ApplicationScoped
public class MoltiplicatoreProducer {

    @Produces
    @Fattorizzato
    public Moltiplicatore getMoltiplicatore(InjectionPoint injectionPoint) {
        int fattore = injectionPoint.getAnnotated().getAnnotation(Fattorizzato.class).fattore();
        return new Moltiplicatore(fattore);
    }

}
