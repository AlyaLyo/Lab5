package Commands;

import City.City;
import City.CityConstructor;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Обновляет значение элемента коллекции, id которого равен заданному.
 */

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

    public static String name() { return "update_id"; }

    public static Information getInfo() throws Exception {
        return new Information(1,0,true,false, Arrays.asList("id"), Arrays.asList(CityConstructor.class));
    }
}
