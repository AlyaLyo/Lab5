package City.Fields;

import Exceptions.InputException;

/**
 * Класс координат.
 */

public class Coordinates {

    private double x;
    private Integer y;

    public Coordinates (double x, Integer y) {
        this.setX(x);
        this.setY(y);
    }

    private void setX(double x) {
        this.x = x;
    }

    private void setY(Integer y) {
        if (y == null) {
            throw new InputException("Exception: Field 'y' can not be null");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + ',' + y.toString();
    }
}
