package Commands;

import City.City;

import java.util.LinkedList;

public class AverageOfMetersAboveSeaLevel implements Commands {

    private LinkedList<City> cities;

    public AverageOfMetersAboveSeaLevel(LinkedList<City> cities) {
        this.cities = cities;
    }

    @Override
    public void execute() {
        Integer sum = 0;
        for (City city : cities) {
            sum = city.getMetersAboveSeaLevel();
        }
        Integer average = sum / cities.size();
        System.out.println(average);
    }

}
