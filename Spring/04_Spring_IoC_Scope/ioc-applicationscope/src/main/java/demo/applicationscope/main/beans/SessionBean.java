package demo.applicationscope.main.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionBean extends AbstractBeanWithID {
}
