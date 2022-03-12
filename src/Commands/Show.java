package Commands;

import City.City;
import IO.Printable;

import java.util.LinkedList;

public class Show implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public Show(LinkedList<City> cities, Printable printable){
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() {
        for (City city : cities) {
            printable.println("Name: " + city.getName() + " id: " + city.getId());
        }
    }
}
