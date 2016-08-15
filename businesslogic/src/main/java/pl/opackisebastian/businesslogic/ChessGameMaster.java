package pl.opackisebastian.businesslogic;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.opackisebastian.businesslogic.board.Board;
import pl.opackisebastian.businesslogic.board.ChessBoard;
import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.exceptions.InvalidPieceMoveException;
import pl.opackisebastian.businesslogic.exceptions.InvalidTraceFreeException;
import pl.opackisebastian.businesslogic.exceptions.MoveException;

/**
 * Created by seb on 25.02.16.
 */

@Component
public class ChessGameMaster {

    private ChessBoard chessBoard;

    public ChessGameMaster() {
        this.chessBoard = new ChessBoard();
        chessBoard.setPiecesOnStartPos();
    }

    public Board move(Coords sourceField, Coords destinationField) {
        try {
            chessBoard.move(sourceField, destinationField);
        } catch (MoveException e) {
            e.printStackTrace();
        }

        return chessBoard;
    }
}


