package pl.opackisebastian.businesslogic.board;

import java.util.Objects;

/**
 * Created by seb on 28.02.16.
 */
public class Coords implements Comparable<Coords>, Cloneable {
    private Integer x;
    private Integer y;

    public Coords() {
        x = 0;
        y = 0;
    }

    public Coords(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void incY(){
        ++y;
    }

    public void incX(){
        ++x;
    }

    public void decY(){
        --y;
    }

    public void decX(){
        --x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Coords other = (Coords) obj;
        return Objects.equals(x, other.x) && Objects.equals(y, other.y);
    }

    @Override
    public int hashCode() {
        int result = 9;

        result = 37 * result * Objects.hashCode(x);
        result = 37 * result * Objects.hashCode(y);
        return result;
    }

    @Override
    public int compareTo(Coords o) {
        if (this.getX().compareTo(o.getX()) == 0)
            return this.getY().compareTo(o.getY());
        return this.getX().compareTo(o.getX());
    }

    @Override
    public Coords clone(){
        return new Coords(x, y);
    }
}