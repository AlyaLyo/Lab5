package Commands;

import City.City;
import IO.Printable;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Выводит среднее значение поля metersAboveSeaLevel для всех элементов коллекции.
 */

public class AverageOfMetersAboveSeaLevel implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public AverageOfMetersAboveSeaLevel(LinkedList<City> cities, Printable printable) {
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() throws IOException {
        Integer sum = 0;
        for (City city : cities) {
            sum = city.getMetersAboveSeaLevel();
        }
        Integer average = sum / cities.size();
        printable.println(average.toString());
    }

    public static String name() {
        return "average_of_meters_above_sea_level";
    }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,true, null,null);
    }

}
