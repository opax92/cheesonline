package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

/**
 * Created by seb on 25.02.16.
 */
public class King extends Piece{

    public King(PieceColor pieceColor) {
        super(0, pieceColor);
    }

    public King(){
        super();
    }

    @Override
    public boolean canMove(Coords source, Coords destination) {
        return Math.abs(source.getX() - destination.getX()) <= 1 && Math.abs(source.getY() - destination.getY()) <= 1;
    }
}
