package pl.opackisebastian.businesslogic.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.opackisebastian.businesslogic.board.ChessBoard;

/**
 * Created by seb on 15.06.16.
 */

@Component
public class HelloService {

    public String getName(){
        ChessBoard b;
        return "eloszek";
    }
}
