package net.zonia3000.producers1;

import java.io.Serializable;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Moltiplicatore implements Serializable {

    private static final long serialVersionUID = -8517447321723736174L;

    private final int fattore;
    private int value;

    public Moltiplicatore() {
        this(1);
    }

    public Moltiplicatore(int fattore) {
        this.fattore = fattore;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValoreMoltiplicato() {
        return fattore * value;
    }
}
