package Commands;

import City.City;

import java.util.LinkedList;

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

}
