package pl.opackisebastian.webui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.opackisebastian.businesslogic.player.ColorValue;
import pl.opackisebastian.webui.filter.Filter;
import pl.opackisebastian.webui.filter.FilterCreator;
import pl.opackisebastian.webui.filter.FilterService;
import pl.opackisebastian.webui.user.UserData;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by seb on 13.08.16.
 */
@Controller
@RequestMapping("/")
public class GameController {

    private final UserData userData;

    private final FilterCreator filterCreator;

    private final FilterService filterService;

    @Autowired
    public GameController(UserData userData, FilterCreator filterCreator, FilterService filterService) {
        this.userData = userData;
        this.filterCreator = filterCreator;
        this.filterService = filterService;
    }

    @RequestMapping
    public String mainController(HttpServletRequest httpServletRequest, Model model) {
        String url = new String(httpServletRequest.getRequestURL());
        model.addAttribute("url", url);
        return "main";
    }

    @RequestMapping("/isGameActive")
    @ResponseBody
    public Boolean isGameActive(){
        return userData.getFilter() != null;
    }

    @RequestMapping("/newGame")
    @ResponseBody
    public Integer createNewGame(@RequestParam(value = "initiatorName") String initiatorName) {
        //TODO DRY, correct that
        if(userData.getFilter() != null){
            throw new IllegalStateException();
        }

        Filter filter = filterCreator.createNewFilter();
        userData.setFilter(filter);
        userData.setColor(ColorValue.WHITE);
        userData.setName(initiatorName);
        filterService.addFilter(filter);

        return filter.getId();
    }

}
