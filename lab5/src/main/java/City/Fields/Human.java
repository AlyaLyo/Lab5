package City.Fields;

import java.time.LocalDate;

/**
 * Класс человека.
 */

public class Human {

    private java.time.LocalDate birthday;

    public Human (java.time.LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return birthday.toString();
    }
}
