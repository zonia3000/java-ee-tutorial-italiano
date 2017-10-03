package net.zonia3000.cdidemo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@ApplicationScoped
public class ApplicationData {

    private int counter;

    @Inject
    SessionData sessionData;

    public synchronized int incrementCounter() {
        return counter++;
    }

    public String getInfo() {
        int appCounter = incrementCounter();
        int sessionCounter = sessionData.incrementCounter();
        return "appcounter = " + appCounter + ", sessionCounter=" + sessionCounter;
    }
}
