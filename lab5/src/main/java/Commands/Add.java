package Commands;

import City.City;
import City.CityConstructor;
import IO.Printable;

import java.util.Arrays;
import java.util.LinkedList;

public class Add implements Commands {

    private LinkedList<City> cities;
    private City city;
    private Printable printable;

    public Add(LinkedList<City> cities, Printable printable, City city) {
        this.cities = cities;
        this.city = city;
        this.printable = printable;
    }

    @Override
    public void execute() {
        cities.add(city);
    }

    public static String name() { return "add"; }

    public static Information getInfo() throws Exception {
        return new Information(0,1,true,true, null, Arrays.asList(CityConstructor.class));
    }

}
