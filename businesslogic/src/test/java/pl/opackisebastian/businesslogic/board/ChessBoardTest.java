package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.exceptions.CheckException;
import pl.opackisebastian.businesslogic.exceptions.InvalidPieceMoveException;
import pl.opackisebastian.businesslogic.exceptions.InvalidTraceFreeException;
import pl.opackisebastian.businesslogic.exceptions.MoveException;
import pl.opackisebastian.businesslogic.pieces.Piece;
import pl.opackisebastian.businesslogic.pieces.PieceColor;
import pl.opackisebastian.businesslogic.piecesImpl.*;
import pl.opackisebastian.businesslogic.field.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on 26.02.16.
 */
public class ChessBoardTest {
    private ChessBoard chessBoard;

    @Test
    public void testSimpleInvalidTraceFreeException() throws Exception {
        chessBoard.setPiecesOnStartPos();
        boolean thrown = false;

        try {
            chessBoard.move(new Coords(0, 0), new Coords(3, 0));
        } catch (MoveException moveException) {
            if (moveException instanceof InvalidTraceFreeException) {
                thrown = true;
            }
        }

        assertTrue(thrown);
    }

    @Test
    public void testSimpleInvalidPieceMoveException() throws Exception {
        chessBoard.setPiecesOnStartPos();
        boolean thrown = false;

        try {
            chessBoard.move(new Coords(0, 0), new Coords(3, 3));
        } catch (MoveException moveException) {
            if (moveException instanceof InvalidPieceMoveException) {
                thrown = true;
            }
        }

        assertTrue(thrown);
    }

    @Test
    public void testSimplePieceMove() throws Exception {
        chessBoard.setPiecesOnStartPos();
        Piece toMove = chessBoard.getField(1, 4).getPiece();

        chessBoard.move(new Coords(1, 4), new Coords(3, 4));

        assertSame(chessBoard.getField(3, 4).getPiece(), toMove);
    }

    @Test
    public void testMoreCorrectPieceMoves() throws Exception {
        chessBoard.setPiecesOnStartPos();
        Piece pawnWhite = chessBoard.getField(6, 4).getPiece();
        Piece pawnBlack = chessBoard.getField(1, 4).getPiece();
        Piece knighWhite = chessBoard.getField(7, 6).getPiece();
        Piece knighBlack = chessBoard.getField(0, 1).getPiece();
        Piece queenWhite = chessBoard.getField(7, 3).getPiece();
        Piece queenBlack = chessBoard.getField(0, 3).getPiece();

        chessBoard.move(new Coords(6, 4), new Coords(4, 4));
        chessBoard.move(new Coords(1, 4), new Coords(3, 4));
        chessBoard.move(new Coords(7, 3), new Coords(3, 7));
        chessBoard.move(new Coords(0, 1), new Coords(2, 2));
        chessBoard.move(new Coords(3, 7), new Coords(3, 5));
        chessBoard.move(new Coords(7, 6), new Coords(5, 5));
        chessBoard.move(new Coords(2, 2), new Coords(4, 1));
        chessBoard.move(new Coords(0, 3), new Coords(1, 4));

        assertSame(chessBoard.getField(1, 4).getPiece(), queenBlack);
        assertSame(chessBoard.getField(4, 1).getPiece(), knighBlack);
        assertSame(chessBoard.getField(3, 4).getPiece(), pawnBlack);
        assertSame(chessBoard.getField(4, 4).getPiece(), pawnWhite);
        assertSame(chessBoard.getField(3, 5).getPiece(), queenWhite);
        assertSame(chessBoard.getField(5, 5).getPiece(), knighWhite);
    }

    @Test
    public void testMoreInCorrectPieceMoves() throws Exception {
        chessBoard.setPiecesOnStartPos();
        boolean thrown = false;

        try {
            chessBoard.move(new Coords(6, 4), new Coords(4, 4));
            chessBoard.move(new Coords(1, 4), new Coords(3, 4));
            chessBoard.move(new Coords(7, 3), new Coords(3, 7));
            chessBoard.move(new Coords(0, 1), new Coords(2, 2));
            chessBoard.move(new Coords(3, 7), new Coords(3, 5));
            chessBoard.move(new Coords(7, 6), new Coords(5, 5));
            chessBoard.move(new Coords(2, 2), new Coords(4, 1));
            chessBoard.move(new Coords(0, 3), new Coords(1, 4));
            chessBoard.move(new Coords(3, 5), new Coords(3, 0));
        } catch (InvalidTraceFreeException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testMoveWhichCausingCheckFromEnemy() throws Exception {
        boolean thrown = false;

        chessBoard.setField(new Field(new King(PieceColor.BLACK)), 3, 3);
        chessBoard.setField(new Field(new Knight(PieceColor.BLACK)), 3, 5);
        chessBoard.setField(new Field(new Queen(PieceColor.WHITE)), 3, 7);

        try {
            chessBoard.move(new Coords(3, 5), new Coords(1, 6));
        } catch (MoveException moveException) {
            if (moveException instanceof CheckException) {
                thrown = true;
            }
        }
        assertTrue(thrown);
    }

    @Test
    public void testSetPiecesOnStartPos() throws Exception {
        chessBoard.setPiecesOnStartPos();
        assertEquals(new Rook(PieceColor.BLACK), chessBoard.getField(0, 0).getPiece());
        assertEquals(new Knight(PieceColor.BLACK), chessBoard.getField(0, 1).getPiece());
        assertEquals(new Bishop(PieceColor.BLACK), chessBoard.getField(0, 2).getPiece());
        assertEquals(new Queen(PieceColor.BLACK), chessBoard.getField(0, 3).getPiece());
        assertEquals(new King(PieceColor.BLACK), chessBoard.getField(0, 4).getPiece());
        assertEquals(new Bishop(PieceColor.BLACK), chessBoard.getField(0, 5).getPiece());
        assertEquals(new Knight(PieceColor.BLACK), chessBoard.getField(0, 6).getPiece());
        assertEquals(new Rook(PieceColor.BLACK), chessBoard.getField(0, 7).getPiece());

        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 0).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 1).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 2).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 3).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 4).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 5).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 6).getPiece());
        assertEquals(new Pawn(PieceColor.BLACK), chessBoard.getField(1, 7).getPiece());

        assertEquals(new Rook(PieceColor.WHITE), chessBoard.getField(7, 0).getPiece());
        assertEquals(new Knight(PieceColor.WHITE), chessBoard.getField(7, 1).getPiece());
        assertEquals(new Bishop(PieceColor.WHITE), chessBoard.getField(7, 2).getPiece());
        assertEquals(new Queen(PieceColor.WHITE), chessBoard.getField(7, 3).getPiece());
        assertEquals(new King(PieceColor.WHITE), chessBoard.getField(7, 4).getPiece());
        assertEquals(new Bishop(PieceColor.WHITE), chessBoard.getField(7, 5).getPiece());
        assertEquals(new Knight(PieceColor.WHITE), chessBoard.getField(7, 6).getPiece());
        assertEquals(new Rook(PieceColor.WHITE), chessBoard.getField(7, 7).getPiece());

        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 0).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 1).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 2).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 3).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 4).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 5).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 6).getPiece());
        assertEquals(new Pawn(PieceColor.WHITE), chessBoard.getField(6, 7).getPiece());
    }

    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
    }
}