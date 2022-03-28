import City.City;
import City.Fields.IdController;
import Commands.CommandsManager;
import IO.CSVManager;
import City.NameCityComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {

        IdController idController = IdController.getInstance();
        LinkedList<City> cities = new LinkedList<>();

        Comparator nameComparator = new NameCityComparator();
        Collections.sort(cities,nameComparator);
        //Collections.sort(cities);

        try {
            cities = CSVManager.parse("collection.csv");//args[0]);
        } catch (Exception e){

        }

        CommandsManager commandsManager = new CommandsManager(cities);

        waitForAction(commandsManager);
    }

    private static void waitForAction(CommandsManager commandsManager){
        try {
            commandsManager.consoleCommand().execute();
        } catch (Exception e) {
            e.getMessage();
        }
        waitForAction(commandsManager);
    }

}