package Commands;

import City.City;
import IO.Printable;

import java.util.LinkedList;

public class AverageOfMetersAboveSeaLevel implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public AverageOfMetersAboveSeaLevel(LinkedList<City> cities, Printable printable) {
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() {
        Integer sum = 0;
        for (City city : cities) {
            sum = city.getMetersAboveSeaLevel();
        }
        Integer average = sum / cities.size();
        printable.println(average.toString());
    }

}
