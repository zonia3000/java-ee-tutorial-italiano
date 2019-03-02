package net.zonia3000.producers2;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Named("page")
@SessionScoped
public class PageBean implements Serializable {

    private static final long serialVersionUID = -6352615619770717248L;

    private Tipo tipo;
    
    @Inject
    @Any
    private Instance<TrasformatoreDiStringhe> trasformatori;

    @PostConstruct
    public void init() {
        tipo = Tipo.MAIUSCOLATORE;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public TrasformatoreDiStringhe getTrasformatore() {
        return trasformatori.select(new TipizzatoQualifier(tipo)).get();
    }
}
