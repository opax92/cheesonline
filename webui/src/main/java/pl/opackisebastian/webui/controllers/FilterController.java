package pl.opackisebastian.webui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.opackisebastian.webui.filter.Filter;
import pl.opackisebastian.webui.user.UserData;

/**
 * Created by seb on 15.08.16.
 */

@Controller
@RequestMapping("/filter")
public class FilterController {

    private final UserData userData;

    @Autowired
    public FilterController(UserData userData) {
        this.userData = userData;
        }

    @RequestMapping("/get")
    @ResponseBody
    public Integer getFilter(){
        Filter filter = userData.getFilter();
        return filter.getId();
    }
}
