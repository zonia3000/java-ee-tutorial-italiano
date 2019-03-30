package demo.applicationscope.mvc2;

import demo.applicationscope.main.beans.SessionBean;
import demo.applicationscope.main.beans.DefaultBean;
import demo.applicationscope.main.beans.RequestBean;
import demo.applicationscope.main.beans.ApplicationBean;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController2 {

    @Autowired
    private DefaultBean defaultBean;

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private RequestBean requestBean;

    @Autowired
    private ApplicationBean applicationBean;

    @GetMapping("/")
    public Map<String, Integer> showDates() {

        Map<String, Integer> beans = new LinkedHashMap<>();

        beans.put("default", defaultBean.getId());
        beans.put("session", sessionBean.getId());
        beans.put("request", requestBean.getId());
        beans.put("application", applicationBean.getId());

        return beans;
    }
}
