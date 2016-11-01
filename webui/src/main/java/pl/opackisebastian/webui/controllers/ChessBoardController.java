package pl.opackisebastian.webui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.opackisebastian.businesslogic.board.Board;
import pl.opackisebastian.businesslogic.services.ChessGameMasterService;
import pl.opackisebastian.businesslogic.filter.Filter;
import pl.opackisebastian.businesslogic.filter.FilterService;
import pl.opackisebastian.businesslogic.user.UserChecker;
import pl.opackisebastian.businesslogic.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by seb on 15.06.16.
 */

@Controller
@RequestMapping("/chessboard")
public class ChessBoardController {

    private final User userData;

    private final ChessGameMasterService chessGameMasterService;

    private final FilterService filterService;

    @Autowired
    public ChessBoardController(User userData, ChessGameMasterService chessGameMasterService, FilterService filterService) {
        this.userData = userData;
        this.chessGameMasterService = chessGameMasterService;
        this.filterService = filterService;
    }

    @RequestMapping
    public String board(HttpServletRequest httpServletRequest, @RequestParam("filter") String filterHash, Model model) {
        Filter filter = createFlter(filterHash);
        model.addAttribute("setName", new UserChecker().userSetName(filter, userData.getName()));
        model.addAttribute("url", new String(httpServletRequest.getRequestURL()));
        model.addAttribute("name", userData.getName());
        model.addAttribute("color", userData.getColor());
        model.addAttribute("filter", filter.getId());
        return "chessboard";
    }

    @RequestMapping("/setOpponentName")
    @ResponseBody
    public Boolean seOpponentName(String name) {
        return userData.waitingForOpponent(name);
    }

    @RequestMapping("/move")
    @ResponseBody
    public String doMove(String filter, String source, String destination) {
        Board board = chessGameMasterService.move(source, destination);

        return null;
    }

    private Filter createFlter(String filter){
        return filterService.findFilter(filter);
    }
}