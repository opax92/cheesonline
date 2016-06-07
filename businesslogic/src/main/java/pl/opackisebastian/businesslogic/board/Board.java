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

    private List<List<Field>> fields;
    private Integer width;
    private Integer height;


    public Board(int width, int height) {
        fields = new ArrayList<>();
            this.width = width;
        this.height = height;
        generateFields(width, height);
    }

    public abstract void setPiecesOnStartPos();

    public abstract Piece move(Coords source, Coords destination) throws MoveException;

    private void generateFields(int width, int height) {
        for (int i = 0; i < width; ++i) {
            fields.add(new ArrayList<>());
            for (int y = 0; y < height; ++y) {
                fields.get(i).add(new Field());
            }
        }
    }

    public void setField(Field field, int x, int y){
        fields.get(x).set(y, field);
    }

    public Field getField(int x, int y) {
        return fields.get(x).get(y);
    }

    public Field getField(Coords coords) {
        return fields.get(coords.getX()).get(coords.getY());
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
