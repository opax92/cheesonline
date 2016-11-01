package pl.opackisebastian.webui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.opackisebastian.businesslogic.filter.Filter;
import pl.opackisebastian.businesslogic.user.User;

/**
 * Created by seb on 15.08.16.
 */

@Controller
@RequestMapping("/filter")
public class FilterController {

    private final User userData;

    @Autowired
    public FilterController(User userData) {
        this.userData = userData;
        }

    @RequestMapping("/get")
    @ResponseBody
    public Integer getFilter(){
        Filter filter = userData.getFilter();
        return filter.getId();
    }

}
