package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;
import pl.opackisebastian.businesslogic.piecesImpl.*;

import java.util.Map;

/**
 * Created by seb on 15.09.16.
 */
class ChessBoardPiecesSetter{

    private Board chessBoard;

    ChessBoardPiecesSetter(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setPieces() {
        setOtherPieces(0, PieceColor.BLACK);
        setPawns(1, PieceColor.BLACK);
        setOtherPieces(7, PieceColor.WHITE);
        setPawns(6, PieceColor.WHITE);
    }

    public void setPieces(Map<Coords, Piece> coordsPieces){
        for(Map.Entry<Coords, Piece> entry : coordsPieces.entrySet()){
            chessBoard.getField(entry.getKey()).setPiece(entry.getValue());
        }
    }

    private void setPawns(int pos, PieceColor pieceColor) {
        for (int i = 0; i < chessBoard.getWidth(); ++i) {
            chessBoard.getField(pos, i).setPiece(new Pawn(pieceColor));
        }
    }

    private void setOtherPieces(int x, PieceColor pieceColor) {
        chessBoard.getField(x, 0).setPiece(new Rook(pieceColor));
        chessBoard.getField(x, 1).setPiece(new Knight(pieceColor));
        chessBoard.getField(x, 2).setPiece(new Bishop(pieceColor));
        chessBoard.getField(x, 3).setPiece(new Queen(pieceColor));
        chessBoard.getField(x, 4).setPiece(new King(pieceColor));
        chessBoard.getField(x, 5).setPiece(new Bishop(pieceColor));
        chessBoard.getField(x, 6).setPiece(new Knight(pieceColor));
        chessBoard.getField(x, 7).setPiece(new Rook(pieceColor));
    }
}
