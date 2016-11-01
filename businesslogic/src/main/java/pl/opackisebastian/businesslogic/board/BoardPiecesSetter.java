package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.pieces.Piece;

import java.util.Map;

/**
 * Created by seb on 15.09.16.
 */
interface BoardPiecesSetter {

    void setPiecesOnStartPos();
    void setPieces(Map<Coords, Piece> piecesCoords);

}
