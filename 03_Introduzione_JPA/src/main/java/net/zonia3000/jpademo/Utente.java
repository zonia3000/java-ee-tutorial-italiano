package net.zonia3000.jpademo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Entity
//@NamedQueries({
//    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
//})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;

    // NOTA: questa opzione cascade e' necessaria per Hibernate, mentre se si
    // usa EclipseLink il programma funziona anche senza. Non mi ero accorta di
    // questo problema quando ho fatto il video. La spiegazione sul cascade la
    // potete trovare nel video numero 10.
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Libro> libri;
    
    public Utente() {
        libri = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.zonia3000.jpademo.Utente[ id=" + id + " ]";
    }
}
