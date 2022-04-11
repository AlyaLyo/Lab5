package Commands;

import City.City;

import java.util.LinkedList;

/**
 * Выводит и удаляет первый элемент коллекции.
 */

public class RemoveHead implements Commands {

    /**
     * Коллекция городов.
     */

    private LinkedList<City> cities;

    /**
     * @param cities Коллекция городов.
     */

    public RemoveHead(LinkedList<City> cities) {
        this.cities = cities;
    }

    /**
     * Метод, запускающий выполнение команды.
     */

    @Override
    public void execute() {
        System.out.println(cities.removeFirst().getName());
    }

    /**
     * @return Command name.
     */

    public static String name() { return "remove_head"; }

    /**
     * @return Command information.
     */

    public static Information getInfo() throws Exception {
        return new Information(0,0,true,false, null, null);
    }

}
