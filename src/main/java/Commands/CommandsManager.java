package Commands;

import City.City;
import City.CityConstructor;
import Exceptions.InputException;
import IO.ConsolePrint;
import IO.ConsoleScan;
import IO.Printable;
import IO.Scannable;
import org.reflections.Reflections;

import java.util.*;

/**
 * Класс, отвечающий за считывание команды.
 */

public class CommandsManager {

    private LinkedList<City> cities;

    public CommandsManager(LinkedList<City> cities) {
        this.cities = cities;
    }

    public Commands consoleCommand () throws Exception {
        Printable printable = new ConsolePrint();
        Scannable scannable = new ConsoleScan(new Scanner(System.in));
        printable.print("Enter command: ");

        String nextCommand = scannable.scanString();
        Class<? extends Commands> command = getCommand(nextCommand);
        Information information = getCommandInfo(command);
        List<String> simpleArguments = scanConsoleSimpleArgs(information,printable,scannable);
        List<Object> complexArguments = scanConsoleComplexArgs(information,printable,scannable);

        Commands newCommand = commandConstructor(command,simpleArguments,complexArguments,information,printable);
        return newCommand;
    }

    public List<Commands> fileCommands(Scannable scannable) throws Exception {
        List<Commands> commands = new ArrayList<>();
        while (scannable.hasNextLine()) {
            String line = scannable.scanString();

            if (line == null) {
                break;
            }
            if (line.equals("")) {
                continue;
            }

            List<String> words = Arrays.asList(line.split("[ \r]"));
            Class<? extends Commands> command = getCommand(words.get(0));
            Information information = getCommandInfo(command);
            List<String> simpleArguments = scanFileSimpleArgs(information,words);
            List<Object> complexArguments = scanFileComplexArgs(information,new ConsolePrint(),scannable);
            Commands newCommand = commandConstructor(command,simpleArguments,complexArguments,information,new ConsolePrint());
            commands.add(newCommand);
        }
        return commands;
    }

    private Class<? extends Commands> getCommand(String commandName) throws Exception {
        Reflections reflections = new Reflections("Commands");
        for(Class<? extends Commands> command : reflections.getSubTypesOf(Commands.class)) {
            if (command.getMethod("name").invoke(null).equals(commandName.trim())) {
                return command;
            }
        }
        throw new InputException("Exception: Wrong command");
    }

    private Information getCommandInfo(Class<? extends Commands> command) throws Exception {
        return (Information) command.getMethod("getInfo").invoke(null);
    }

    private List<String> scanConsoleSimpleArgs (Information information, Printable printable, Scannable scannable) throws Exception {
        List<String> simpleArguments = new ArrayList<>();
        for (int i = 0; i < information.getSimpleArguments(); ++i) {
            printable.print("Enter " + information.getDescription().get(i) + " : ");
            simpleArguments.add(scannable.scanString());
        }
        return simpleArguments;
    }

    private List<String> scanFileSimpleArgs (Information information, List<String> fromFile) {
        List<String> simpleArguments = new ArrayList<>();
        for (int i = 0; i < information.getSimpleArguments(); ++i) {
            simpleArguments.add(fromFile.get(i));
        }
        return simpleArguments;
    }

    private List<Object> scanConsoleComplexArgs (Information information,Printable printable, Scannable scannable) throws Exception {
        List<Object> complexArguments = new ArrayList<>();
        for (int i = 0; i < information.getComplexArguments(); ++i) {
            CityConstructor constructor = (CityConstructor) information.getConstructors().get(i).getConstructors()[0].newInstance(printable,scannable);
            complexArguments.add(constructor.scanFromConsoleConstruct());
        }
        return complexArguments;
    }

    private List<Object> scanFileComplexArgs (Information information, Printable printable, Scannable scannable) throws Exception {
        List<Object> complexArguments = new ArrayList<>();
        for (int i = 0; i < information.getComplexArguments(); ++i) {
            CityConstructor constructor = (CityConstructor) information.getConstructors().get(i).getConstructors()[0].newInstance(printable,scannable);
            complexArguments.add(constructor.scanFromFileConstruct());
        }
        return complexArguments;
    }

    private Commands commandConstructor (Class<? extends Commands> command, List<String> simpleArguments, List<Object> complexArguments, Information information, Printable printable) throws Exception {
        List<Object> arguments = new ArrayList<>();
        if (information.getIsCity()) {
            arguments.add(cities);
        }
        if (information.getIsPrintable()) {
            arguments.add(printable);
        }
        arguments.addAll(simpleArguments);
        arguments.addAll(complexArguments);
        return (Commands) command.getConstructors()[0].newInstance(arguments.toArray());
    }

}

