package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by seb on 25.02.16.
 */
public class Knight extends Piece {
    private static int KNIGHT_VALUE = 3;

    public Knight(PieceColor pieceColor) {
        super(KNIGHT_VALUE, pieceColor);
    }

    public Knight() {
        super();
    }

    @Override
    public Set<Coords> generateTrace(Coords source, Coords destination) {
        return Collections.emptySet();
    }

    @Override
    public boolean canMove(Coords source, Coords destination) {
        Set<Integer> diffXY = new HashSet<>();

        diffXY.add(Math.abs(source.getX() - destination.getX()));
        diffXY.add(Math.abs(source.getY() - destination.getY()));

        return diffXY.contains(1) && diffXY.contains(2);
    }
}

