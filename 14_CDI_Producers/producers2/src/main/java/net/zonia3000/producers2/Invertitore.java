package net.zonia3000.producers2;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Invertitore extends TrasformatoreDiStringhe {

    private static final long serialVersionUID = -7825805216311716673L;

    @Override
    public String getValoreTrasformato() {
        if (getValue() == null) {
            return null;
        }
        return new StringBuilder(getValue()).reverse().toString();
    }
}
