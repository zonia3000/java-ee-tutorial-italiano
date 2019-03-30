package demo.scope.beans;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractBeanWithID implements IdHolder {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final int id;

    public AbstractBeanWithID() {
        id = COUNTER.addAndGet(1);
    }

    @Override
    public int getId() {
        return id;
    }
}
