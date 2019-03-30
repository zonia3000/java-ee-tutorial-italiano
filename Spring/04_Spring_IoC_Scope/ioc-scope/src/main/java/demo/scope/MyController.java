package demo.scope;

import demo.scope.beans.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private DefaultBean defaultBean;

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private RequestBean requestBean;
    
    @Autowired
    private IdHolder prototypeBean;

    @GetMapping("/")
    public Map<String, Integer> showBeans() {

        Map<String, Integer> beans = new LinkedHashMap<>();

        beans.put("default", defaultBean.getId());
        System.out.println(defaultBean.getClass());
        
        beans.put("session", sessionBean.getId());
        System.out.println(sessionBean.getClass());
        
        beans.put("request", requestBean.getId());
        System.out.println(requestBean.getClass());

        beans.put("prototype", prototypeBean.getId());
        
        beans.put("prototype-from-request", requestBean.getPrototypeBean().getId());
        
        return beans;
    }
}
