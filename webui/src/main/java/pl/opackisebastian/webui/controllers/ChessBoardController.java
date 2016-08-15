package pl.opackisebastian.webui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.opackisebastian.businesslogic.board.Board;
import pl.opackisebastian.businesslogic.services.ChessGameMasterService;
import pl.opackisebastian.webui.filter.Filter;
import pl.opackisebastian.webui.filter.FilterRepository;
import pl.opackisebastian.webui.filter.FilterService;
import pl.opackisebastian.webui.user.UserData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by seb on 15.06.16.
 */

@Controller
@RequestMapping("/chessboard")
public class ChessBoardController {

    private final UserData userData;

    private final ChessGameMasterService chessGameMasterService;

    private final FilterService filterService;

    @Autowired
    public ChessBoardController(UserData userData, ChessGameMasterService chessGameMasterService, FilterService filterService) {
        this.userData = userData;
        this.chessGameMasterService = chessGameMasterService;
        this.filterService = filterService;
    }

    @RequestMapping
    public String board(HttpServletRequest httpServletRequest, String filter, Model model) {
        Filter f = filterService.findFilter(filter);
        String name = userData.getName();

        if (f.waitForOpponent() && name == null) {
            model.addAttribute("setName", "true");
        }
        model.addAttribute("url", new String(httpServletRequest.getRequestURL()));
        model.addAttribute("name", userData.getName());
        model.addAttribute("color", userData.getColor());
        model.addAttribute("filter", f.getId());
        return "chessboard";
    }

    @RequestMapping("/setOpponentName")
    @ResponseBody
    public Boolean seOpponentName(String filter, String name) {
        Filter f = filterService.findFilter(filter);
        if(f.waitForOpponent()){
            f.waitForOpponent(false);
            userData.setFilter(f);
            userData.setName(name);
            return true;
        }

        return false;
    }

    @RequestMapping("/move")
    @ResponseBody
    public String doMove(String filter, String source, String destination) {

        Board board = chessGameMasterService.move(source, destination);

        return null;
    }
}