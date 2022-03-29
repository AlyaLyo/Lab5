package Commands;

import City.City;

import java.util.LinkedList;

/**
 * Удаляет первый элемент коллекции.
 */

public class RemoveFirst implements Commands{

    private LinkedList<City> cities;

    public RemoveFirst(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        cities.removeFirst();
    }

    public static String name() { return "remove_first"; }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,false, null, null);
    }

}
