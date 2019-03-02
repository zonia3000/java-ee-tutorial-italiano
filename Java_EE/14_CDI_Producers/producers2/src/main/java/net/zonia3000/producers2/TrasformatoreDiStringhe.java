package net.zonia3000.producers2;

import java.io.Serializable;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public abstract class TrasformatoreDiStringhe implements Serializable {

    private static final long serialVersionUID = 6294189926303616787L;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public abstract String getValoreTrasformato();
}
