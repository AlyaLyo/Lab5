package Commands;

import City.City;
import IO.Printable;

import java.io.IOException;
import java.util.*;

/**
 * Выводит в стандартный поток вывода информацию о коллекции.
 */

public class Info implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public Info (LinkedList<City> cities, Printable printable) {
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() throws IOException {
        printable.println("Тип коллекции:"  + cities.getClass() + "\nВремя инициализации:" + InitTimeController.getInstance().getInitTime(cities) + "\nКоличество элементов:" + cities.size());
    }

    public static String name() {
        return "info";
    }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,true, null,null);
    }

}
