package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by seb on 26.02.16.
 */
public class RookTest {

    @Test
    public void testCanMove() throws Exception {
        Rook rook = new Rook();

        assertTrue(rook.canMove(new Coords(0, 0), new Coords(0, 3)));
        assertTrue(rook.canMove(new Coords(0, 0), new Coords(0, 7)));
        assertTrue(rook.canMove(new Coords(0, 0), new Coords(5, 0)));
        assertTrue(rook.canMove(new Coords(0, 0), new Coords(1, 0)));
        assertTrue(rook.canMove(new Coords(0, 0), new Coords(7, 0)));

        assertTrue(rook.canMove(new Coords(4, 6), new Coords(4, 0)));
        assertTrue(rook.canMove(new Coords(4, 6), new Coords(4, 7)));
        assertTrue(rook.canMove(new Coords(4, 6), new Coords(4, 2)));
        assertTrue(rook.canMove(new Coords(4, 6), new Coords(0, 6)));
        assertTrue(rook.canMove(new Coords(4, 6), new Coords(2, 6)));
        assertTrue(rook.canMove(new Coords(4, 6), new Coords(7, 6)));

        assertFalse(rook.canMove(new Coords(0, 0), new Coords(1, 1)));
        assertFalse(rook.canMove(new Coords(0, 0), new Coords(4, 5)));
        assertFalse(rook.canMove(new Coords(0, 0), new Coords(2, 4)));
        assertFalse(rook.canMove(new Coords(0, 0), new Coords(7, 7)));

        assertFalse(rook.canMove(new Coords(4, 6), new Coords(7, 7)));
        assertFalse(rook.canMove(new Coords(4, 6), new Coords(2, 7)));
        assertFalse(rook.canMove(new Coords(4, 6), new Coords(3, 3)));
        assertFalse(rook.canMove(new Coords(4, 6), new Coords(0, 0)));
        assertFalse(rook.canMove(new Coords(4, 6), new Coords(6, 4)));
    }
}