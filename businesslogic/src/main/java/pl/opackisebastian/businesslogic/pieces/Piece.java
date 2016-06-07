package pl.opackisebastian.businesslogic.pieces;

import pl.opackisebastian.businesslogic.board.Coords;

import java.util.Objects;

/**
 * Created by seb on 25.02.16.
 */
public abstract class Piece implements ChessMovement {

    private PieceProperties pieceProperties;
    private Boolean isMoved = false;

    public Piece(Integer figureValue, PieceColor pieceColor) {
        this.pieceProperties = new PieceProperties(pieceColor, figureValue);
    }

    public Piece(){
    }

    @Override
    public boolean canKill(final Coords source, final Coords destination){
        return canMove(source, destination);
    }

    public PieceProperties getPieceProperties() {
        return pieceProperties;
    }

    public void setPieceProperties(PieceProperties pieceProperties) {
        this.pieceProperties = pieceProperties;
    }

    public Boolean getMoved()
    {
        return isMoved;
    }

    public void moved() {
        isMoved = true;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result * Objects.hashCode(pieceProperties);
        result = 31 * result * Objects.hashCode(isMoved);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass())
            return false;

        Piece other = (Piece) obj;
        return Objects.equals(pieceProperties, other.pieceProperties) && Objects.equals(isMoved, other.isMoved);
    }
}
