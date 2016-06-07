package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on 27.02.16.
 */
public class KnightTest {

    @Test
    public void testCanMove() throws Exception {
        Knight knight = new Knight();

        assertTrue(knight.canMove(new Coords(0, 0), new Coords(2, 1)));
        assertTrue(knight.canMove(new Coords(0, 0), new Coords(1, 2)));

        assertTrue(knight.canMove(new Coords(4, 4), new Coords(2, 5)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(2, 3)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(3, 2)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(3, 6)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(5, 2)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(5, 6)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(6, 3)));
        assertTrue(knight.canMove(new Coords(4, 4), new Coords(6, 5)));

        assertTrue(knight.canMove(new Coords(7, 7), new Coords(6, 5)));
        assertTrue(knight.canMove(new Coords(7, 7), new Coords(5, 6)));

        assertFalse(knight.canMove(new Coords(7, 7), new Coords(7, 6)));
        assertFalse(knight.canMove(new Coords(7, 7), new Coords(6, 6)));
        assertFalse(knight.canMove(new Coords(7, 7), new Coords(6, 7)));

        assertFalse(knight.canMove(new Coords(0, 0), new Coords(0, 1)));
        assertFalse(knight.canMove(new Coords(0, 0), new Coords(1, 1)));
        assertFalse(knight.canMove(new Coords(0, 0), new Coords(1, 0)));

        assertFalse(knight.canMove(new Coords(7, 7), new Coords(7, 6)));
        assertFalse(knight.canMove(new Coords(7, 7), new Coords(6, 7)));
        assertFalse(knight.canMove(new Coords(7, 7), new Coords(6, 6)));

        assertFalse(knight.canMove(new Coords(4, 4), new Coords(1, 1)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(4, 7)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(7, 4)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(0, 0)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(7, 7)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(2, 6)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(3, 7)));
        assertFalse(knight.canMove(new Coords(4, 4), new Coords(3, 0)));
    }
}