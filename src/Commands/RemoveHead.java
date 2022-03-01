package Commands;

import City.City;

import java.util.LinkedList;

public class RemoveHead implements Commands {

    private LinkedList<City> cities;

    public RemoveHead(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        System.out.println(cities.removeFirst().getName());
    }

}
