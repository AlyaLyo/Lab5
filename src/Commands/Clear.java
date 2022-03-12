package Commands;

import City.City;
import IO.Printable;

import java.util.LinkedList;

public class Clear implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public Clear(LinkedList<City> cities, Printable printable) {
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() {
        cities.clear();
        System.out.println("Collection was cleared");
    }
}
