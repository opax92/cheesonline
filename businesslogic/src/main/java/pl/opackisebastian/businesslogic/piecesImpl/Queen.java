package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

/**
 * Created by seb on 25.02.16.
 */
public class Queen extends Piece  {
    private static int QUEEN_VALUE = 9;

    public Queen(){
        super();
    }

    public Queen(PieceColor pieceColor) {
        super(QUEEN_VALUE, pieceColor);
    }

    @Override
    public boolean canMove(Coords source, Coords destination) {
        return new Rook().canMove(destination, source) || new Bishop().canMove(destination, source);
    }
}
