package Commands;

import City.City;
import IO.Printable;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupCountingByAgglomeration implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    @Override
    public void execute() {
        Map<Long, Set<String>> counting =
                cities.stream().collect(
                        Collectors.groupingBy(City::getAgglomeration,
                                Collectors.mapping(City::getName, Collectors.toSet())
                        )
                );
        printable.println(counting);
    }

}
