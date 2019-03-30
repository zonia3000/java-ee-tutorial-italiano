package demo.applicationscope.main.beans;

import java.util.concurrent.atomic.AtomicInteger;

public class AbstractBeanWithID {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final int id;

    public AbstractBeanWithID() {
        id = COUNTER.addAndGet(1);
    }

    public int getId() {
        return id;
    }
}
