package net.zonia3000.jsfdemo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Named("inserimento")
@RequestScoped
public class InserimentoLibri {

    @Inject
    DatiUtente datiUtente;

    private String titolo;
    private int pagine;

    public void aggiungiLibro() {
        Libro libro = new Libro();
        libro.setTitolo(titolo);
        libro.setPagine(pagine);
        datiUtente.getLibri().add(libro);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }
    
    public String goToNuova() {
        return "nuova.xhtml?faces-redirect=true";
    }
}
