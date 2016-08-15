package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.exceptions.*;
import pl.opackisebastian.businesslogic.field.Field;
import pl.opackisebastian.businesslogic.pieces.ChessMovement;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;
import pl.opackisebastian.businesslogic.piecesImpl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by seb on 25.02.16.
 */
public class ChessBoard extends Board {

    public ChessBoard() {
        super(8, 8);
    }

    @Override
    public void setPiecesOnStartPos() {
        new ChessBoardPiecesSetter().setPieces();
    }

    @Override
    public Piece move(Coords source, Coords destination) throws MoveException {
        if (!isCorrectChessMove(source, destination)) {
            throw new InvalidPieceMoveException();
        }

        return movePiece(source, destination);

        //TODO if source or destination not contains pieces, throw exception
    }

    private boolean isCorrectChessMove(Coords source, Coords destination) {

        ChessMovement sourceMove = getField(source).getPieceMove();
        ChessMovement destinationMove = getField(destination).getPieceMove();

        if (destinationMove != null) {
            return sourceMove.canKill(source, destination);
        }

        return sourceMove.canMove(source, destination);
    }

    private boolean isTraceFree(Set<Coords> coords) {
        for (Coords c : coords) {
            if (getField(c).getPiece() != null)
                return false;
        }
        return true;
    }

    private Piece movePiece(final Coords source, final Coords destination) throws MoveException {
        Field sourceField = getField(source);
        Piece sourcePiece = sourceField.getPiece();

        try {
            if (!isTraceFree(sourcePiece.generateTrace(source, destination))) {
                throw new InvalidTraceFreeException();
            }
        } catch (GenerateTraceException e) {
            throw new RuntimeException("Caused by GenerateTraceException");
        }

        if (new ChessCheckChecker(sourcePiece.getPieceProperties().getPieceColor()).isCheck(source)) {
            throw new CheckException();
        }

        return switchPieces(sourceField, getField(destination));
    }

    private Piece switchPieces(final Field sourceField, final Field destinationField){
        Piece pieceToMove = sourceField.getPieceAndSetEmptyField();
        pieceToMove.moved();

        Piece killedPiece = null;

        if (destinationField.getPiece() != null) {
            killedPiece = destinationField.getPiece();
        }

        destinationField.setPiece(pieceToMove);
        return killedPiece;
    }

    private class ChessBoardPiecesSetter {
        private void setPawns(int x, PieceColor pieceColor) {
            for (int i = 0; i < 8; ++i) {
                getField(x, i).setPiece(new Pawn(pieceColor));
            }
        }

        private void setOtherPieces(int x, PieceColor pieceColor) {
            getField(x, 0).setPiece(new Rook(pieceColor));
            getField(x, 1).setPiece(new Knight(pieceColor));
            getField(x, 2).setPiece(new Bishop(pieceColor));
            getField(x, 3).setPiece(new Queen(pieceColor));
            getField(x, 4).setPiece(new King(pieceColor));
            getField(x, 5).setPiece(new Bishop(pieceColor));
            getField(x, 6).setPiece(new Knight(pieceColor));
            getField(x, 7).setPiece(new Rook(pieceColor));
        }

        void setPieces() {
            setOtherPieces(0, PieceColor.BLACK);
            setPawns(1, PieceColor.BLACK);
            setOtherPieces(7, PieceColor.WHITE);
            setPawns(6, PieceColor.WHITE);
        }
    }

    private class ChessCheckChecker {
        private PieceColor pieceColor;

        public ChessCheckChecker(PieceColor pieceColor) {
            this.pieceColor = pieceColor;
        }

        public boolean isCheck(Coords source) {
            Coords kingCoords = getKingCoords();
            Map<Coords, ChessMovement> coordsChessMovementMap = getAllEnemyMovement();

            Piece tmp = getField(source).getPieceAndSetEmptyField();

            for(Map.Entry<Coords, ChessMovement> entry: coordsChessMovementMap.entrySet()){
                if(entry.getValue().canKill(entry.getKey(), kingCoords)){
                    try {
                        if(isTraceFree(entry.getValue().generateTrace(entry.getKey(), kingCoords))){
                            getField(source).setPiece(tmp);
                            return true;
                        }
                    } catch (GenerateTraceException e) {
                        throw new RuntimeException("Caused by GenerateTraceException");
                    }
                }
            }

            getField(source).setPiece(tmp);
            return false;
        }

        private Map<Coords, ChessMovement> getAllEnemyMovement(){
            Map<Coords, ChessMovement> coordsChessMovementMap = new HashMap<>();

            for(int i = 0; i < getWidth(); ++i){
                for(int y = 0; y < getHeight(); ++y){
                    Piece piece = getField(i, y).getPiece();
                    if(piece == null){
                        continue;
                    }
                    if(!piece.getPieceProperties().getPieceColor().equals(pieceColor)){
                        coordsChessMovementMap.put(new Coords(i, y), getField(i, y).getPieceMove());
                    }
                }
            }

            return coordsChessMovementMap;
        }

        private Coords getKingCoords() {
            for (int i = 0; i < getWidth(); ++i) {
                for (int y = 0; y < getHeight(); ++y) {
                    Piece piece = getField(i, y).getPiece();
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

}
