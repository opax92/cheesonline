package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.exceptions.*;
import pl.opackisebastian.businesslogic.field.Field;
import pl.opackisebastian.businesslogic.pieces.ChessMovement;
import pl.opackisebastian.businesslogic.pieces.Piece;

import java.util.Map;
import java.util.Set;

/**
 * Created by seb on 25.02.16.
 */
public class ChessBoard extends Board implements BoardPiecesSetter{

    private static final Integer chessBoardWidth = 8;
    private static final Integer chessBoardHeight = 8;

    public ChessBoard() {
        super(chessBoardWidth, chessBoardHeight);
    }

    @Override
    public void setPiecesOnStartPos() {
        new ChessBoardPiecesSetter(this).setPieces();
    }

    @Override
    public void setPieces(Map<Coords, Piece> piecesCoords) {
        new ChessBoardPiecesSetter(this).setPieces(piecesCoords);
    }

    @Override
    public Piece move(Coords source, Coords destination) throws MoveException {
        if (!isCorrectChessMove(source, destination)) {
            throw new InvalidPieceMoveException();
        }

        return movePiece(source, destination);

        //TODO if source or destination not contains pieces, throw exception
    }

    boolean isTraceFree(Set<Coords> coords) {
        for (Coords c : coords) {
            if (getField(c).getPiece() != null)
                return false;
        }
        return true;
    }

    private boolean isCorrectChessMove(Coords source, Coords destination) {

        ChessMovement sourceMove = getField(source).getPieceMove();
        ChessMovement destinationMove = getField(destination).getPieceMove();

        if (destinationMove != null) {
            return sourceMove.canKill(source, destination);
        }

        return sourceMove.canMove(source, destination);
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

        if (new ChessCheckChecker(this, sourcePiece.getPieceProperties().getPieceColor()).isCheck(source)) {
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

}
