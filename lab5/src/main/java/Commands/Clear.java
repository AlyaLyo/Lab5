package Commands;

import City.City;
import IO.Printable;

import java.util.Arrays;
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
    }

    public static String name() {
        return "clear";
    }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,false, null, null);
    }

}
