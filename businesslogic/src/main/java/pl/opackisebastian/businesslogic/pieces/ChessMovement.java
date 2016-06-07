package pl.opackisebastian.businesslogic.pieces;

import pl.opackisebastian.businesslogic.trace.ChessTraceGenerator;
import pl.opackisebastian.businesslogic.trace.TraceGenerator;
import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.exceptions.GenerateTraceException;

import java.util.Set;

/**
 * Created by seb on 28.02.16.
 */
public interface ChessMovement extends TraceGenerator<Coords>{
    boolean canKill(final Coords source, final Coords destination);
    boolean canMove(final Coords source, final Coords destination);

    @Override
    default Set<Coords> generateTrace(Coords source, Coords destination) throws GenerateTraceException {
        return new ChessTraceGenerator().generateTrace(source, destination);
    }
}
