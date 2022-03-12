package Commands;

import City.City;
import City.Fields.Climate;
import City.Fields.Coordinates;
import City.Fields.Human;
import City.Fields.IdController;
import IO.Printable;
import IO.Scannable;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.EnumSet;
import java.util.LinkedList;

public class Add implements Commands {

    private LinkedList<City> cities;
    private City city;
    private Printable printable;
    private Scannable scannable;

    public Add(LinkedList<City> cities,City city, Printable printable, Scannable scannable) {
        this.cities = cities;
        this.city = city;
        this.printable = printable;
        this.scannable = scannable;
    }

    @Override
    public void execute() {
        cities.add(city);
    }

    public City scan() {
        printable.print("Enter a name: ");
        String name = scannable.scanString();

        printable.print("Enter x coordinate: ");
        Double x = scannable.scanDouble();
        printable.print("Enter y coordinate: ");
        Integer y = scannable.scanInteger();
        Coordinates coordinates = new Coordinates(x,y);

        printable.print("Enter an area: ");
        int area = scannable.scanInteger();

        printable.print("Enter a population: ");
        long population = scannable.scanLong();

        printable.print("Enter meters above sea level: ");
        Integer metersAboveSeaLevel = scannable.scanInteger();

        printable.print("Enter a telephone code: ");
        long telephoneCode = scannable.scanLong();

        printable.print("Enter an agglomeration: ");
        long agglomeration = scannable.scanLong();

        printable.print("Choose a climate " + EnumSet.allOf(Climate.class)  + ": ");
        String climateName = scannable.scanString();
        Climate climate = null;
        switch (climateName) {
            case "RAIN_FOREST" :
                climate = Climate.RAIN_FOREST;
            case  "TROPICAL_SAVANNA" :
                climate = Climate.TROPICAL_SAVANNA;
            case  "HUMIDSUBTROPICAL" :
                climate = Climate.HUMIDSUBTROPICAL;
            case  "STEPPE" :
                climate = Climate.STEPPE;
        }

        printable.print("Enter a birth year of governor :");
        int year = scannable.scanInteger();
        printable.print("Enter a birth month of governor :");
        int month = scannable.scanInteger();
        printable.print("Enter a birth day of governor :");
        int day = scannable.scanInteger();
        Human governor = new Human(LocalDate.of(year, month, day));

        City city = new City(IdController.getInstance().getNewId(), name, coordinates, ZonedDateTime.now(), area, population, metersAboveSeaLevel, telephoneCode, agglomeration, climate,governor);
        return city;
    }

}
