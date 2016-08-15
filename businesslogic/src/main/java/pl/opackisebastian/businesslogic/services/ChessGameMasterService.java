package pl.opackisebastian.businesslogic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.opackisebastian.businesslogic.ChessGameMaster;
import pl.opackisebastian.businesslogic.board.Board;
import pl.opackisebastian.businesslogic.board.ChessBoard;

/**
 * Created by seb on 15.06.16.
 */

@Service
public class ChessGameMasterService {

    private final ChessGameMaster chessGameMaster;

    @Autowired
    public ChessGameMasterService(ChessGameMaster chessGameMaster) {
        this.chessGameMaster = chessGameMaster;
    }

    public ChessBoard move(String source, String destination) {
        return null;
    }
}
