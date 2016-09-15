package pl.opackisebastian.businesslogic.board;

import org.junit.Before;
import org.junit.Test;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

import static org.junit.Assert.*;

/**
 * Created by seb on 15.09.16.
 */
public class ChessCheckCheckerTest {

    private ChessCheckChecker chessCheckChecker;
    private ChessBoard chessBoard = new ChessBoard();

    @Before
    public void setUp() throws Exception {
        PieceColor pieceColor = PieceColor.BLACK;
        chessBoard.setPiecesOnStartPos();
        chessCheckChecker = new ChessCheckChecker(chessBoard, pieceColor);
    }

    @Test
    public void testSimpleCheck(){
//        chessBoard.move()
    }
}