package net.zonia3000.producers1;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Named("page")
@RequestScoped
public class PageBean {

    @Inject
    @Fattorizzato(fattore = 5)
    private Moltiplicatore moltiplicatore;

    public Moltiplicatore getMoltiplicatore() {
        return moltiplicatore;
    }

    public void setMoltiplicatore(Moltiplicatore moltiplicatore) {
        this.moltiplicatore = moltiplicatore;
    }
}
