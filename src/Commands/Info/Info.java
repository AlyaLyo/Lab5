package Commands.Info;

import City.City;
import Commands.Commands;
import IO.Printable;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Dictionary;
import java.util.HashMap;


import java.time.LocalTime;

public class Info implements Commands {

    private LinkedList<City> cities;
    private InitTimeController initTime;
    private Printable printable;

    public Info (LinkedList<City> cities, InitTimeController initTime, Printable printable) {
        this.cities = cities;
        this.initTime = initTime;
        this.printable = printable;
    }

    @Override
    public void execute() {
        printable.println("Тип коллекции:"  + cities.getClass() + "\nВремя инициализации:" + initTime.getInitTime(cities) + "\nКоличество элементов:" + cities.size());
    }
}
