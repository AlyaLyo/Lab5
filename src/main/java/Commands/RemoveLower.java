package Commands;

import City.City;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Удаляет из коллекции все элементы, меньшие, чем заданный.
 */

public class RemoveLower implements Commands {

    private City city;
    private LinkedList<City> cities;

    public RemoveLower(City city,LinkedList<City> cities) {
        this.city = city;
        this.cities = cities;
    }

    @Override
    public void execute() {
        int index = cities.indexOf(city);
        for (int i = index + 1; i <= cities.size(); i++) {
            cities.remove(i);
        }
    }

    public static String name() { return "remove_lower"; }

    public static Information getInfo() throws Exception {
        return new Information(1,0,true,false, Arrays.asList("number"), null);
    }

}
