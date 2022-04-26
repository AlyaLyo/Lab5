import City.City;
import City.NameCityComparator;
import Commands.CommandsManager;
import IO.CSVManager;
import IO.ConsolePrint;
import IO.Printable;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Главный класс приложения.
 */

public class Main {

    /**
     * Точка входа.
     * @param args Путь к файлу с коллекцией.
     */

    public static void main(String[] args) throws Exception {
        
        //if (args.size())

        System.setProperty("org.slf4j.simpleLogger.log.org.reflections", "off");

        LinkedList<City> cities = new LinkedList<>();

        Comparator nameComparator = new NameCityComparator();
        Collections.sort(cities,nameComparator);
        //Collections.sort(cities);

        try {
            cities = CSVManager.parse(args[0]);
        } catch (Exception e){
            System.out.println("File is requested");
            System.exit(0);
        }

        Printable printable = new ConsolePrint();
        CommandsManager commandsManager = new CommandsManager(cities);

        waitForAction(commandsManager, printable);
    }

    /**
     * Метод, считывающий и выполняющий команду.
     * @param commandsManager Считывание команды.
     * @param printable Вывод.
     */

    private static void waitForAction(CommandsManager commandsManager, Printable printable) throws IOException {
        try {
            commandsManager.consoleCommand().execute();
        } catch (Exception exception) {
            printable.println(exception.getMessage());
        }
        waitForAction(commandsManager, printable);
    }

}