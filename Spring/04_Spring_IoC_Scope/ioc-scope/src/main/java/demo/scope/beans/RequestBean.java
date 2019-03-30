package demo.scope.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean extends AbstractBeanWithID {

    @Autowired
    private IdHolder prototypeBean;

    public IdHolder getPrototypeBean() {
        return prototypeBean;
    }

}
