package net.zonia3000.cdidemo;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@SessionScoped
public class SessionData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int counter;
    
    @Inject
    DependentData dep;
        
    @PostConstruct
    public void init() {
        System.out.println("hey!!!");
    }
        
    public synchronized int incrementCounter() {
        return counter++;
    }
}
