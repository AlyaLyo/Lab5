package Commands;

import City.City;

import java.util.LinkedList;

public class RemoveFirst implements Commands{

    private LinkedList<City> cities;

    public RemoveFirst(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        cities.removeFirst();
    }

}
