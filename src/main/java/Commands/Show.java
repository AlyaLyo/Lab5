package Commands;

import City.City;
import IO.Printable;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 */

public class Show implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public Show(LinkedList<City> cities, Printable printable){
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() throws IOException {
        for (City city : cities) {
            printable.println("Name: " + city.getName() + " id: " + city.getId());
        }
    }

    public static String name() { return "show"; }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,true,null, null);
    }

}
