package City;

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

public class CityConstructor {

    private Printable printable;
    private Scannable scannable;
    private LinkedList<City> cities;

    public CityConstructor(Printable printable, Scannable scannable, LinkedList<City> cities) {
        this.printable = printable;
        this.scannable = scannable;
        this.cities = cities;
    }

    public City scanFromConsoleConstruct() throws Exception {
        City city = null;
        try {
            int id = IdController.getInstance().getNewId(cities);
            String name = setName();
            Coordinates coordinates = setCoordinates();
            java.time.ZonedDateTime creationDate = ZonedDateTime.now();
            int area = setArea();
            long population = setPopulation();
            Integer metersAboveSeaLevel = setMetersAboveSeaLevel();
            long telephoneCode = setTelephoneCode();
            long agglomeration = setAgglomeration();
            Climate climate = setClimate();
            Human governor = setGovernor();
            city = new City(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, telephoneCode, agglomeration, climate, governor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return scanFromConsoleConstruct();
        }
        return city;
    }

    public City scanFromFileConstruct() throws Exception {
        int id = IdController.getInstance().getNewId(cities);
        String name = scannable.scanString();

        Double x = scannable.scanDouble();
        Integer y = scannable.scanInteger();
        Coordinates coordinates = new Coordinates(x,y);

        java.time.ZonedDateTime creationDate = ZonedDateTime.now();
        int area = scannable.scanInteger();
        long population = scannable.scanLong();
        Integer metersAboveSeaLevel = scannable.scanInteger();
        long telephoneCode = scannable.scanLong();
        long agglomeration = scannable.scanLong();

        String climateName = scannable.scanString();
        Climate climate = null;
        switch (climateName) {
            case "RAIN_FOREST":
                climate = Climate.RAIN_FOREST;
            case "TROPICAL_SAVANNA":
                climate = Climate.TROPICAL_SAVANNA;
            case "HUMIDSUBTROPICAL":
                climate = Climate.HUMIDSUBTROPICAL;
            case "STEPPE":
                climate = Climate.STEPPE;
        }

        int year = scannable.scanInteger();
        int month = scannable.scanInteger();
        int day = scannable.scanInteger();
        Human governor = new Human(LocalDate.of(year, month, day));

        City city = new City(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, telephoneCode, agglomeration, climate, governor);
        return city;
    }

    private String setName() throws Exception {
        String name = null;
        printable.print("Enter a name: ");
        while (name == null || name.equals("")){

            name = scannable.scanString();
        }
        try {
            return name;
        } catch (Exception e){
            printable.println(e.getMessage());
            return setName();
        }
    }

    private Coordinates setCoordinates() throws Exception {
        try {
            printable.print("Enter x coordinate: ");
            Double x = scannable.scanDouble();
            printable.print("Enter y coordinate: ");
            Integer y = scannable.scanInteger();
            Coordinates coordinates = new Coordinates(x,y);
            return coordinates;
        } catch (Exception e){
            printable.println(e.getMessage());
            return setCoordinates();
        }

    }

    private int setArea() throws Exception {
        printable.print("Enter an area: ");

        try {
            int area = scannable.scanInteger();
            return area;
        } catch (Exception e){
            printable.println(e.getMessage());
            return setArea();
        }

    }

    private long setPopulation() throws Exception {
        printable.print("Enter a population: ");
        try {
            long population = scannable.scanLong();
            return population;
        } catch (Exception e){
            printable.println(e.getMessage());
            return setPopulation();
        }
    }

    private Integer setMetersAboveSeaLevel() throws Exception {
        printable.print("Enter meters above sea level: ");
        try {
            Integer metersAboveSeaLevel = scannable.scanInteger();
            return metersAboveSeaLevel;
        } catch (Exception e) {
            printable.println(e.getMessage());
            return setMetersAboveSeaLevel();
        }

    }

    private long setTelephoneCode() throws Exception {
        printable.print("Enter a telephone code: ");

        try {
            long telephoneCode = scannable.scanLong();
            return telephoneCode;
        } catch (Exception e) {
            return setTelephoneCode();
        }

    }

    private long setAgglomeration() throws Exception {
        printable.print("Enter an agglomeration: ");
        try {
            long agglomeration = scannable.scanLong();
            return agglomeration;
        } catch (Exception e){
            printable.println(e.getMessage());
            return setAgglomeration();
        }

    }

    private Climate setClimate() throws Exception {
        String climateName;
        Climate climate = null;
        printable.print("Choose a climate " + EnumSet.allOf(Climate.class)  + ": ");
        while (climate == null){
            climateName = scannable.scanString();
            climate = Climate.parse(climateName);
        }
        return climate;
    }

    private Human setGovernor() throws Exception {

        try {
            printable.print("Enter a birth year of governor :");
            int year = scannable.scanInteger();
            printable.print("Enter a birth month of governor :");
            int month = scannable.scanInteger();
            printable.print("Enter a birth day of governor :");
            int day = scannable.scanInteger();
            Human governor = new Human(LocalDate.of(year, month, day));
            return governor;
        } catch (Exception e){
            printable.println(e.getMessage());
            return setGovernor();
        }

    }

    public static City parse(String... strings) {
        City city = new City();
        city.setId(Integer.parseInt(strings[0]));
        city.setName(strings[1]);
        city.setCoordinates(new Coordinates(Double.parseDouble(strings[2]), Integer.parseInt(strings[3])));
        city.setCreationDate(ZonedDateTime.parse(strings[4]));
        city.setArea(Integer.parseInt(strings[5]));
        city.setPopulation(Long.parseLong(strings[6]));
        city.setMetersAboveSeaLevel(Integer.parseInt(strings[7]));
        city.setTelephoneCode(Long.parseLong(strings[8]));
        city.setAgglomeration(Long.parseLong(strings[9]));
        city.setClimate(Climate.parse(strings[10]));
        city.setGovernor(new Human(LocalDate.parse(strings[11])));
        return city;
    }
}
