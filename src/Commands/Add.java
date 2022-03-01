package Commands;

import City.City;

import java.util.LinkedList;

public class Add implements Commands {

    private LinkedList<City> cities;
    private City city;

    public Add(LinkedList<City> cities,City city) {
        this.cities = cities;
        this.city = city;
    }

    @Override
    public void execute() {
        cities.add(city);
    }

}
