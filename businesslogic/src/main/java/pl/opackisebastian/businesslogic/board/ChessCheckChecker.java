package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.exceptions.GenerateTraceException;
import pl.opackisebastian.businesslogic.pieces.ChessMovement;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;
import pl.opackisebastian.businesslogic.piecesImpl.King;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seb on 15.09.16.
 */
class ChessCheckChecker {

    private ChessBoard chessBoard;
    private PieceColor pieceColor;

    ChessCheckChecker(ChessBoard chessBoard, PieceColor pieceColor) {
        this.chessBoard = chessBoard;
        this.pieceColor = pieceColor;
    }

    boolean isCheck(Coords source) {
        Coords kingCoords = getKingCoords();
        Map<Coords, ChessMovement> coordsChessMovementMap = getAllEnemyMovement();

        Piece tmp = chessBoard.getField(source).getPieceAndSetEmptyField();

        for (Map.Entry<Coords, ChessMovement> entry : coordsChessMovementMap.entrySet()) {
            if (entry.getValue().canKill(entry.getKey(), kingCoords)) {
                try {
                    if (chessBoard.isTraceFree(entry.getValue().generateTrace(entry.getKey(), kingCoords))) {
                        chessBoard.getField(source).setPiece(tmp);
                        return true;
                    }
                } catch (GenerateTraceException e) {
                    throw new RuntimeException("Caused by GenerateTraceException");
                }
            }
        }

        chessBoard.getField(source).setPiece(tmp);
        return false;
    }

    private Map<Coords, ChessMovement> getAllEnemyMovement() {
        Map<Coords, ChessMovement> coordsChessMovementMap = new HashMap<>();

        for (int i = 0; i < chessBoard.getWidth(); ++i) {
            for (int y = 0; y < chessBoard.getHeight(); ++y) {
                Piece piece = chessBoard.getField(i, y).getPiece();
                if (piece == null) {
                    continue;
                }
                if (!piece.getPieceProperties().getPieceColor().equals(pieceColor)) {
                    coordsChessMovementMap.put(new Coords(i, y), chessBoard.getField(i, y).getPieceMove());
                }
            }
        }

        return coordsChessMovementMap;
    }

    private Coords getKingCoords() {
        for (int i = 0; i < chessBoard.getWidth(); ++i) {
            for (int y = 0; y < chessBoard.getHeight(); ++y) {
                Piece piece = chessBoard.getField(i, y).getPiece();
                if (piece == null) {
                    continue;
                }
                if (piece.equals(new King(pieceColor))) {
                    return new Coords(i, y);
                }
            }
        }
        throw new RuntimeException("King not found on board!");
    }
}
