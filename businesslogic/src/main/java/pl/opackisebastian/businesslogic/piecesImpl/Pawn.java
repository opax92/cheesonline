package pl.opackisebastian.businesslogic.piecesImpl;

import pl.opackisebastian.businesslogic.board.Coords;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;

import java.util.Objects;

/**
 * Created by seb on 25.02.16.
 */
public class Pawn extends Piece {
    private static int PAWN_VALUE = 1;

    public Pawn(PieceColor pieceColor) {
        super(PAWN_VALUE, pieceColor);
    }

    public Pawn(){
        super();
    }

    @Override
    public boolean canMove(Coords source, Coords destination) {
        int moveLen = 1;

        if(!getMoved()){
            ++moveLen;
        }

        switch(getPieceProperties().getPieceColor()){
            case BLACK:
                if(source.getX() - destination.getX() >= -moveLen && Objects.equals(destination.getY(), source.getY()))
                    return true;
                break;
            case WHITE:
                if(source.getX() - destination.getX() <= moveLen && Objects.equals(destination.getY(), source.getY()))
                    return true;
        }

        return false;
    }

    @Override
    public boolean canKill(Coords source, Coords destination){
        return false;
    }
}
