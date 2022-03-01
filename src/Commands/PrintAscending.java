package Commands;

import City.City;

import java.util.LinkedList;

public class PrintAscending implements Commands {

    private LinkedList<City> cities;

    public PrintAscending(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        for (City city : cities) {
            System.out.println(city.getName());
        }
    }

}
