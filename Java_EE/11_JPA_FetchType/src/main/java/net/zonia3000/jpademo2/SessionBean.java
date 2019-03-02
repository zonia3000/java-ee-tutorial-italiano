package net.zonia3000.jpademo2;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Named("sessionData")
@SessionScoped
public class SessionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PersistenceBean persistenceBean;

    private Utente utente;

    private boolean showLibri;

    public void caricaDatiUtente() {
        utente = persistenceBean.getUtente();
    }

    public boolean isShowLibri() {
        return showLibri;
    }

    public void setShowLibri(boolean showLibri) {
        this.showLibri = showLibri;
    }

    public Utente getUtente() {
        return utente;
    }
}
