package pl.opackisebastian.businesslogic.piecesImpl;

import org.junit.Test;

import static org.junit.Assert.*;
import pl.opackisebastian.businesslogic.board.Coords;

/**
 * Created by seb on 27.02.16.
 */
public class QueenTest {

    @Test
    public void testCanMove() throws Exception {
        Queen queen = new Queen();

        assertTrue(queen.canMove(new Coords(0, 0), new Coords(1, 1)));
        assertTrue(queen.canMove(new Coords(0, 0), new Coords(0, 1)));
        assertTrue(queen.canMove(new Coords(0, 0), new Coords(1, 0)));
        assertTrue(queen.canMove(new Coords(0, 0), new Coords(7, 7)));
        assertTrue(queen.canMove(new Coords(0, 0), new Coords(0, 7)));
        assertTrue(queen.canMove(new Coords(0, 0), new Coords(7, 0)));

        assertTrue(queen.canMove(new Coords(4, 2), new Coords(4, 0)));
        assertTrue(queen.canMove(new Coords(4, 2), new Coords(4, 6)));
        assertTrue(queen.canMove(new Coords(4, 2), new Coords(0, 2)));
        assertTrue(queen.canMove(new Coords(4, 2), new Coords(7, 2)));
        assertTrue(queen.canMove(new Coords(4, 2), new Coords(6, 4)));

        assertFalse(queen.canMove(new Coords(5, 5), new Coords(4, 3)));
        assertFalse(queen.canMove(new Coords(5, 5), new Coords(2, 3)));
        assertFalse(queen.canMove(new Coords(5, 5), new Coords(1, 3)));
        assertFalse(queen.canMove(new Coords(5, 5), new Coords(4, 2)));
        assertFalse(queen.canMove(new Coords(5, 5), new Coords(4, 0)));
    }
}