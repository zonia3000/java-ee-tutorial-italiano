package net.zonia3000.jsfdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Named("utente")
@SessionScoped
public class DatiUtente implements Serializable {

    private static final long serialVersionUID = 7319500272366934970L;

    private List<Libro> libri;
    
    @PostConstruct
    public void init() {
        libri = new ArrayList<>();
    }

    public List<Libro> getLibri() {
        return libri;
    }
}
