package Commands;

import City.City;

import java.util.LinkedList;

/**
 * Выводит и удаляет первый элемент коллекции.
 */

public class RemoveHead implements Commands {

    private LinkedList<City> cities;

    public RemoveHead(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        System.out.println(cities.removeFirst().getName());
    }

    public static String name() { return "remove_head"; }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,false, null, null);
    }

}
