package pl.opackisebastian.businesslogic.piecesImpl;

import org.junit.Test;

import static org.junit.Assert.*;
import pl.opackisebastian.businesslogic.board.Coords;

/**
 * Created by seb on 26.02.16.
 */
public class BishopTest {

    @Test
    public void testCanMove() throws Exception {
        Bishop bishop = new Bishop();

        assertTrue(bishop.canMove(new Coords(0, 0), new Coords(1, 1)));
        assertTrue(bishop.canMove(new Coords(1, 1), new Coords(0, 0)));
        assertTrue(bishop.canMove(new Coords(0, 0), new Coords(5, 5)));
        assertTrue(bishop.canMove(new Coords(5, 5), new Coords(0, 0)));
        assertTrue(bishop.canMove(new Coords(0, 0), new Coords(7, 7)));
        assertTrue(bishop.canMove(new Coords(7, 7), new Coords(0, 0)));
        assertTrue(bishop.canMove(new Coords(5, 5), new Coords(7, 3)));
        assertTrue(bishop.canMove(new Coords(7, 3), new Coords(5, 5)));

        assertFalse(bishop.canMove(new Coords(7, 3), new Coords(7, 2)));
        assertFalse(bishop.canMove(new Coords(7, 3), new Coords(7, 4)));
        assertFalse(bishop.canMove(new Coords(7, 3), new Coords(6, 3)));
        assertFalse(bishop.canMove(new Coords(4, 2), new Coords(3, 2)));
        assertFalse(bishop.canMove(new Coords(4, 2), new Coords(4, 3)));
        assertFalse(bishop.canMove(new Coords(4, 2), new Coords(4, 1)));

        assertFalse(bishop.canMove(new Coords(7, 4), new Coords(7, 0)));
        assertFalse(bishop.canMove(new Coords(7, 4), new Coords(7, 7)));
        assertFalse(bishop.canMove(new Coords(7, 4), new Coords(0, 4)));
    }
}