package City;

import City.City;

import java.util.Comparator;

public class NameCityComparator implements Comparator<City> {

    @Override
    public int compare(City city1, City city2) {
        if (city1 == city2) {
            return 0;
        }
        if (city1 == null) {
            return -1;
        }
        if (city2 == null) {
            return 1;
        }
        return city1.compareTo(city2);
    }

}
