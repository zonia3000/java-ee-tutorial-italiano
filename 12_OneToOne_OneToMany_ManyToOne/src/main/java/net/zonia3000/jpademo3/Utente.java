package net.zonia3000.jpademo3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@Entity
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinTable(name = "utente_indirizzo",
            joinColumns = {@JoinColumn(name = "id_utente", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "id_indirizzo", referencedColumnName = "ID")})
    private List<Indirizzo> indirizzi;

    private String username;

    public Utente() {
        indirizzi = new ArrayList<>();
    }

    public Utente(String username) {
        this();
        this.username = username;
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

    public List<Indirizzo> getIndirizzi() {
        return indirizzi;
    }

//    public void setIndirizzo(Indirizzo indirizzo) {
//        this.indirizzo = indirizzo;
//    }

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
        return "net.zonia3000.jpademo3.Utente[ id=" + id + " ]";
    }

}
