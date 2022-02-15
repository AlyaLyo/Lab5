package City.Fields;

import City.FieldException;

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
            throw new FieldException("Exception: Field 'y' can not be null");
        }
        this.y = y;
    }

}
