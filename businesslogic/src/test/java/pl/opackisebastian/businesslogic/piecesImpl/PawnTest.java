package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.PieceColor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on 27.02.16.
 */
public class PawnTest {
    @Test
    public void testCanMove() throws Exception {
        Pawn whitePawn = new Pawn(PieceColor.WHITE);
        Pawn blackPawn = new Pawn(PieceColor.BLACK);

        assertTrue(blackPawn.canMove(new Coords(0, 0), new Coords(1, 0)));
        assertTrue(whitePawn.canMove(new Coords(7, 7), new Coords(6, 7)));

        assertTrue(blackPawn.canMove(new Coords(3, 3), new Coords(4, 3)));
        assertTrue(whitePawn.canMove(new Coords(3, 3), new Coords(2, 3)));

        assertTrue(blackPawn.canMove(new Coords(6, 2), new Coords(7, 2)));
        assertTrue(whitePawn.canMove(new Coords(6, 2), new Coords(5, 2)));

        assertTrue(blackPawn.canMove(new Coords(0, 0), new Coords(2, 0)));

        assertFalse(blackPawn.canMove(new Coords(0, 0), new Coords(7, 2)));
        assertFalse(blackPawn.canMove(new Coords(0, 0), new Coords(0, 2)));
        assertFalse(blackPawn.canMove(new Coords(0, 0), new Coords(7, 7)));
        assertFalse(blackPawn.canMove(new Coords(0, 0), new Coords(2, 2)));

        blackPawn.moved();
        assertFalse(blackPawn.canMove(new Coords(0, 0), new Coords(2, 0)));
    }
}