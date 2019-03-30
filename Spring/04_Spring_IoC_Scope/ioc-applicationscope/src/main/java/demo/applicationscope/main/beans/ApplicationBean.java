
package demo.applicationscope.main.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class ApplicationBean extends AbstractBeanWithID {
}
