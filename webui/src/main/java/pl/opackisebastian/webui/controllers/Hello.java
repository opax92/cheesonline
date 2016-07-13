package pl.opackisebastian.webui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.opackisebastian.businesslogic.services.HelloService;

/**
 * Created by seb on 15.06.16.
 */

@Controller
public class Hello {

    private final HelloService helloService;

    @Autowired
    public Hello(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String f(){
        return helloService.getName();
    }
}
