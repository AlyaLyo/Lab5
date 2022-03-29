package Commands;

import City.City;
import IO.CSVManager;
import IO.Printable;

import java.util.LinkedList;

/**
 * Сохраняет коллекцию в файл.
 */

public class Save implements Commands{

    private LinkedList<City> cities;
    private Printable printable;

    public Save(LinkedList<City> cities){
        this.cities = cities;
    }

    @Override
    public void execute() throws Exception {
        CSVManager.toCSV(cities);
    }

    public static String name() { return "save"; }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,false, null, null);
    }

}
