package Commands;

import City.City;
import IO.Printable;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class PrintAscending implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public PrintAscending(LinkedList<City> cities, Printable printable) {
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() throws IOException {
        for (City city : cities) {
            printable.println("Name: " + city.getName());
        }
    }

    public static String name() { return "print_ascending"; }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,true, null, null);
    }

}
