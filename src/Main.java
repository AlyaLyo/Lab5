import City.*;
import City.Fields.Climate;
import City.Fields.Coordinates;
import City.Fields.Human;
import City.Fields.IdController;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        IdController idController = IdController.getInstance();

        Coordinates londonCoordinates = new Coordinates(15,100);
        Human john = new Human(LocalDate.of(2012,10,5));
        City london = new City(idController.getNewId(),"London",londonCoordinates,ZonedDateTime.now(),17,1000,100,42,36, Climate.RAIN_FOREST, john);

        Coordinates moscowCoordinates = new Coordinates(67,123);
        Human ivan = new Human(LocalDate.of(2001,1,17));
        City moscow = new City(idController.getNewId(),"Moscow",moscowCoordinates,ZonedDateTime.now(),5,10000,108,7,78,Climate.TROPICAL_SAVANNA,ivan);

        Coordinates spbCoordinates = new Coordinates(12,21);
        Human spbgovernor = new Human(LocalDate.of(2000,6,4));
        City spb = new City(idController.getNewId(),"Spb",spbCoordinates, ZonedDateTime.now(),6,3456,5,555,444,Climate.HUMIDSUBTROPICAL,spbgovernor);

        LinkedList<City> cities = new LinkedList<>();
        cities.add(london);
        cities.add(spb);
        cities.add(moscow);

        //Comparator nameComparator = new NameCityComparator();
        //Collections.sort(cities,nameComparator);
        Collections.sort(cities);

        for (City city : cities) {
            System.out.println(city.getId() + " " + city.getName());
        }

    }

}