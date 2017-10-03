package net.zonia3000.producers2;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@ApplicationScoped
public class TrasformatoreProducer {

    @Produces
    @SessionScoped
    @Tipizzato(Tipo.MAIUSCOLATORE)
    public TrasformatoreDiStringhe getMaiuscolatore() {
        return new Maiuscolatore();
    }

    @Produces
    @SessionScoped
    @Tipizzato(Tipo.INVERTITORE)
    public TrasformatoreDiStringhe getInvertitore() {
        return new Invertitore();
    }
}
