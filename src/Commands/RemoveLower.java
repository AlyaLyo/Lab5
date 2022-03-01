package Commands;

import City.City;

import java.util.LinkedList;

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

}
