package net.zonia3000.producers2;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Maiuscolatore extends TrasformatoreDiStringhe {

    private static final long serialVersionUID = -1902501263179417415L;

    @Override
    public String getValoreTrasformato() {
        if (getValue() == null) {
            return null;
        }
        return getValue().toUpperCase();
    }
}
