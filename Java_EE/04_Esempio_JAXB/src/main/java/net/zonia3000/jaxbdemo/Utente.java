package net.zonia3000.jaxbdemo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@XmlRootElement
public class Utente {

    private String nome;
    private String email;

    private List<Libro> libri;

    public Utente() {
        libri = new ArrayList<>();
    }

    @XmlAttribute
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElementWrapper
    @XmlElement(name = "libro")
    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }
}
