package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on 27.02.16.
 */
public class KingTest {

    @Test
    public void testCanMove() throws Exception {
        King king = new King();

        assertTrue(king.canMove(new Coords(0, 0), new Coords(0, 1)));
        assertTrue(king.canMove(new Coords(0, 0), new Coords(1, 1)));
        assertTrue(king.canMove(new Coords(0, 0), new Coords(1, 0)));

        assertTrue(king.canMove(new Coords(2, 2), new Coords(1, 1)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(1, 2)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(1, 3)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(2, 1)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(2, 3)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(3, 3)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(3, 2)));
        assertTrue(king.canMove(new Coords(2, 2), new Coords(3, 1)));

        assertFalse(king.canMove(new Coords(0, 0), new Coords(2, 2)));
        assertFalse(king.canMove(new Coords(0, 0), new Coords(0, 2)));
        assertFalse(king.canMove(new Coords(0, 0), new Coords(2, 0)));

        assertFalse(king.canMove(new Coords(3, 3), new Coords(1, 1)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(7, 7)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(3, 5)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(3, 7)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(1, 3)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(3, 1)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(5, 2)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(0, 0)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(3, 0)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(0, 3)));
        assertFalse(king.canMove(new Coords(3, 3), new Coords(6, 6)));

        assertFalse(king.canMove(new Coords(5, 5), new Coords(3, 3)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(3, 2)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(3, 4)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(7, 2)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(7, 3)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(7, 4)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(5, 3)));
        assertFalse(king.canMove(new Coords(5, 5), new Coords(5, 7)));

    }
}