package Commands;

import City.City;

import java.util.LinkedList;

public class Clear implements Commands {

    private LinkedList<City> cities;

    public Clear(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        cities.clear();
        System.out.println("Collection was cleared");
    }
}
