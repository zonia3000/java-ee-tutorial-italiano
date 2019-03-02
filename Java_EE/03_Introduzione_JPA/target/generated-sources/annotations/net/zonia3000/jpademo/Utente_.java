package net.zonia3000.jpademo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.zonia3000.jpademo.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-11T18:34:41")
@StaticMetamodel(Utente.class)
public class Utente_ { 

    public static volatile SingularAttribute<Utente, Long> id;
    public static volatile SingularAttribute<Utente, String> email;
    public static volatile SingularAttribute<Utente, String> username;
    public static volatile ListAttribute<Utente, Libro> libri;

}