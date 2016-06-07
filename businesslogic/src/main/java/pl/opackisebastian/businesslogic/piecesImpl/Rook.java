package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

import java.util.Objects;

/**
 * Created by seb on 25.02.16.
 */
public class Rook extends Piece {
    private static int ROOK_VALUE = 5;

    public Rook(PieceColor pieceColor) {
        super(ROOK_VALUE, pieceColor);
    }

    public Rook(){
        super();
    }

    @Override
    public boolean canMove(Coords source, Coords destination) {
        return Objects.equals(source.getX(), destination.getX()) || Objects.equals(source.getY(), destination.getY());
    }
}
