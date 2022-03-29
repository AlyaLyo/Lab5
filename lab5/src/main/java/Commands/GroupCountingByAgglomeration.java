package Commands;

import City.City;
import IO.Printable;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupCountingByAgglomeration implements Commands {

    private LinkedList<City> cities;
    private Printable printable;

    public GroupCountingByAgglomeration(LinkedList<City> cities, Printable printable){
        this.cities = cities;
        this.printable = printable;
    }

    @Override
    public void execute() throws IOException {
        Map<Long, Set<String>> counting =
                cities.stream().collect(
                        Collectors.groupingBy(City::getAgglomeration,
                                Collectors.mapping(City::getName, Collectors.toSet())
                        )
                );
        printable.println(counting.toString());
    }

    public static String name() {
        return "group_counting_by_agglomeration";
    }

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,true, null, null);
    }

}