package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.exceptions.MoveException;
import pl.opackisebastian.businesslogic.field.Field;
import pl.opackisebastian.businesslogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on 25.02.16.
 */

public abstract class Board {

    private Fields fields;
    private Integer width;
    private Integer height;

    Board(int width, int height) {
        this.width = width;
        this.height = height;
        fields = new Fields(width, height);
    }

    public abstract Piece move(Coords source, Coords destination) throws MoveException;

    void setField(Field field, int x, int y) {
        fields.setField(field, x, y);
    }

    Field getField(int x, int y) {
        return fields.getField(x, y);
    }

    Field getField(Coords coords) {
        return fields.getField(coords.getX(), (coords.getY()));
    }

    Integer getWidth() {
        return width;
    }

    Integer getHeight() {
        return height;
    }
}
