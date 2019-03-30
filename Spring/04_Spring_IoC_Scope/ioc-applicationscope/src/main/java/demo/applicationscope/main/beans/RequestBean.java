package demo.applicationscope.main.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean extends AbstractBeanWithID {
}
