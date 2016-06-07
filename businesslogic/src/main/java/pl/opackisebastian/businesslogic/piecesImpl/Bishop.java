package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

/**
 * Created by seb on 25.02.16.
 */
public class Bishop extends Piece  {
    private static int BISHOP_VALUE = 3;

    public Bishop(PieceColor pieceColor) {
        super(BISHOP_VALUE, pieceColor);
    }

    public Bishop(){
        super();
    }

    @Override
    public boolean canMove(Coords source, Coords destination) {
        return Math.abs(source.getX() - destination.getX()) == Math.abs(source.getY() - destination.getY());
    }
}
