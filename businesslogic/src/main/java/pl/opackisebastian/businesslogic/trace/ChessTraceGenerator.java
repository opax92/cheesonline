package pl.opackisebastian.businesslogic.trace;

import org.springframework.beans.factory.annotation.Autowired;
import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.exceptions.GenerateTraceException;
import pl.opackisebastian.businesslogic.services.HelloService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by seb on 09.03.16.
 */
public class ChessTraceGenerator implements TraceGenerator<Coords> {

    private Set<Coords> coordsSet = new HashSet<>();
    private Integer safetyCounter = 0;
    private Integer iterationLimit;

    //TODO refactoring - DRY in two methods

    @Override
    public Set<Coords> generateTrace(Coords source, Coords destination) throws GenerateTraceException{
        coordsSet.clear();
        coordsSet.add(source.clone());
        coordsSet.add(destination.clone());
        iterationLimit = Math.abs(source.getX()) + Math.abs(destination.getX()) + Math.abs(source.getY()) + Math.abs(destination.getY());

        if (!source.getX().equals(destination.getX()) && !source.getY().equals(destination.getY())) {
            return generateDiagonally();
        }
        return generateInLine();
    }

    private Set<Coords> generateDiagonally() throws GenerateTraceException{
        Set<Coords> coordsResult = new HashSet<>();
        Coords minCoords = Collections.min(coordsSet);
        Coords maxCoords = Collections.max(coordsSet);

        Boolean inc = true;

        if (minCoords.getY() > maxCoords.getY()) {
            inc = false;
        }
        while (!minCoords.equals(maxCoords)) {

            minCoords.incX();
            if (inc) {
                minCoords.incY();
            } else
                minCoords.decY();

            if (!minCoords.equals(maxCoords)) {
                coordsResult.add(minCoords.clone());
            }
            if(++safetyCounter > iterationLimit){
                throw new GenerateTraceException("Can't calculate trace between " + minCoords + " and " + maxCoords);
            }
        }
        return coordsResult;
    }

    private Set<Coords> generateInLine() throws GenerateTraceException{
        Set<Coords> coordsResult = new HashSet<>();
        Coords minCoords = Collections.min(coordsSet);
        Coords maxCoords = Collections.max(coordsSet);

        Boolean inc = true;

        if (minCoords.getX().equals(maxCoords.getX())) {
            inc = false;
        }
        while (!minCoords.equals(maxCoords)) {
            if (inc) {
                minCoords.incX();
            } else {
                minCoords.incY();
            }
            if (!minCoords.equals(maxCoords)) {
                coordsResult.add(minCoords.clone());
            }
            if(++safetyCounter > iterationLimit){
                throw new GenerateTraceException("Can't calculate trace between " + minCoords + " and " + maxCoords);
            }
        }

        return coordsResult;
    }
}
