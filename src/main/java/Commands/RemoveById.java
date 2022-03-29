package Commands;

import City.City;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Удаляет элемент из коллекции по его id.
 */

public class RemoveById implements Commands{

    private int id;
    private LinkedList<City> cities;

    public RemoveById(int id, LinkedList<City> cities) {
        this.cities = cities;
        this.id = id;
    }

    @Override
    public void execute() {
        for (City city : cities) {
            if (city.getId() == id) {
                cities.remove(city);
            }
        }
    }

    public static String name() { return "remove_by_id"; }

    public static Information getInfo() throws Exception {
        return new Information(1,0,true,false, Arrays.asList("id"), null);
    }

}
