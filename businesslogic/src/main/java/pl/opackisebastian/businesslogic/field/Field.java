package pl.opackisebastian.businesslogic.field;

import pl.opackisebastian.businesslogic.pieces.ChessMovement;
import pl.opackisebastian.businesslogic.pieces.Piece;

/**
 * Created by seb on 25.02.16.
 */
public class Field {

    private Piece piece;

    public Field(){

    }

    public Field(Piece piece) {
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Piece getPieceAndSetEmptyField(){
        Piece tempPiece = piece;
        piece = null;
        return tempPiece;
    }

    public ChessMovement getPieceMove(){
        return piece;
    }
}
