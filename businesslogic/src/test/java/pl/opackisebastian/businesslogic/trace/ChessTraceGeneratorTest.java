package pl.opackisebastian.businesslogic.trace;

import pl.opackisebastian.businesslogic.board.Coords;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by seb on 13.03.16.
 */
public class ChessTraceGeneratorTest {
    private ChessTraceGenerator chessTraceGenerator;
    private Set<Coords> coordsSet;
    private Set<Coords> coordsSetComparator;

    @After
    public void tearDown() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        chessTraceGenerator = new ChessTraceGenerator();
        coordsSet = new HashSet<>();
        coordsSetComparator = new HashSet<>();
    }

    @Test
    public void testLine() throws Exception {
        coordsSet = chessTraceGenerator.generateTrace(new Coords(0, 1), new Coords(5, 1));

        coordsSetComparator.add(new Coords(1, 1));
        coordsSetComparator.add(new Coords(2, 1));
        coordsSetComparator.add(new Coords(3, 1));
        coordsSetComparator.add(new Coords(4, 1));

        assertTrue(coordsSet.equals(coordsSetComparator));
    }

    @Test
    public void testLineDiffDirection() throws Exception {
        coordsSet = chessTraceGenerator.generateTrace(new Coords(3, 0), new Coords(3, 4));

        coordsSetComparator.add(new Coords(3, 1));
        coordsSetComparator.add(new Coords(3, 2));
        coordsSetComparator.add(new Coords(3, 3));

        assertTrue(coordsSet.equals(coordsSetComparator));
    }

    @Test
    public void testDiagonally() throws Exception {
        coordsSet = chessTraceGenerator.generateTrace(new Coords(2, 3), new Coords(6, 7));

        coordsSetComparator.add(new Coords(3, 4));
        coordsSetComparator.add(new Coords(4, 5));
        coordsSetComparator.add(new Coords(5, 6));

        assertTrue(coordsSet.equals(coordsSetComparator));
    }

    @Test
    public void testDiagonallyDiffDirection() throws Exception {
        coordsSet = chessTraceGenerator.generateTrace(new Coords(1, 4), new Coords(3, 2));

        coordsSetComparator.add(new Coords(2, 3));

        assertTrue(coordsSet.equals(coordsSetComparator));
    }


}