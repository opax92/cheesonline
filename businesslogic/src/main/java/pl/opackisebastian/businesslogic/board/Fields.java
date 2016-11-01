package pl.opackisebastian.businesslogic.board;

import pl.opackisebastian.businesslogic.field.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seb on 01.11.16.
 */
class Fields {

    private List<List<Field>> fields;

    Fields(int width, int height) {
        fields = new ArrayList<>();
        generateFields(width, height);
    }

    void setField(Field field, int x, int y) {
        fields.get(x).set(y, field);
    }

    Field getField(int x, int y) {
        return fields.get(x).get(y);
    }

    private void generateFields(int width, int height) {
        for (int i = 0; i < width; ++i) {
            fields.add(new ArrayList<>());
            for (int y = 0; y < height; ++y) {
                fields.get(i).add(new Field());
            }
        }
    }
}
