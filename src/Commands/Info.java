package Commands;

import City.City;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Dictionary;
import java.util.HashMap;


import java.time.LocalTime;

public class Info implements Commands {

    private LinkedList<City> cities;
    private InitTimeController initTime;

    public Info (LinkedList<City> cities, InitTimeController initTime) {
        this.cities = cities;
        this.initTime = initTime;
    }

    @Override
    public void execute() {
        System.out.println("Тип коллекции:"  + cities.getClass() + "\nВремя инициализации:" + initTime.getInitTime(cities) + "\nКоличество элементов:" + cities.size());
    }
}
