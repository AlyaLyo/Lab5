package Commands;

import City.City;

import java.util.LinkedList;

public class UpdateId implements Commands{

    private City oldCity;
    private City newCity;
    private LinkedList<City> cities;

    public UpdateId(City oldCity, City newCity, LinkedList<City> cities) {
        this.oldCity = oldCity;
        this.newCity = newCity;
        this.cities = cities;
    }

    @Override
    public void execute() {
        int index = cities.indexOf(oldCity);
        cities.remove(index);
        cities.add(newCity);
        newCity.setId(index + 1);
    }
}
