package pl.opackisebastian.businesslogic.pieces;

import java.util.Objects;

/**
 * Created by seb on 06.03.16.
 */
public class PieceProperties {
    private PieceColor pieceColor;
    private Integer pieceValue;

    public PieceProperties(PieceColor pieceColor, Integer pieceValue) {
        this.pieceColor = pieceColor;
        this.pieceValue = pieceValue;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Integer getPieceValue() {
        return pieceValue;
    }

    public void setPieceValue(Integer pieceValue) {
        this.pieceValue = pieceValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        PieceProperties other = (PieceProperties) obj;
        return Objects.equals(pieceColor, other.pieceColor) && Objects.equals(pieceValue, other.pieceValue);
    }

    @Override
    public int hashCode(){
        int result = 9;
        result = 37 * result * Objects.hashCode(pieceColor);
        result = 37 * result * Objects.hashCode(pieceValue);
        return result;
    }
}