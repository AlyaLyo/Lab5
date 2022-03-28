package Commands;

import City.City;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public final class InitTimeController {

    private static InitTimeController instance;
    private Map<LinkedList<City>,LocalDate> collectionDate = new HashMap<LinkedList<City>,LocalDate>();

    private InitTimeController() {

    }

    public static InitTimeController getInstance() {
        if (instance == null) {
            instance = new InitTimeController();
        }
        return instance;
    }

    public LocalDate getInitTime(LinkedList<City> cities) {
        collectionDate.put(cities,LocalDate.now());
        return collectionDate.get(cities);
    }
}
