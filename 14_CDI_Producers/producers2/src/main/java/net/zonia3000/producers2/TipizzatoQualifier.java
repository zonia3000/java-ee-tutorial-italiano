package net.zonia3000.producers2;

import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class TipizzatoQualifier extends AnnotationLiteral<Tipizzato> implements Tipizzato {

    private final Tipo tipo;

    public TipizzatoQualifier(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public Tipo value() {
        return tipo;
    }

}
