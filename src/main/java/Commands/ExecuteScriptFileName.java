package Commands;

import City.City;
import Exceptions.GetAccessException;
import IO.FileScan;
import IO.Scannable;
import org.reflections.Reflections;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Считывает и исполняет скрипт из указанного файла.
 */

public class ExecuteScriptFileName implements Commands {

    /**
     * Коллекция городов.
     */

    private LinkedList<City> cities;

    /**
     * File name.
     */

    private String fileName;

    /**
     * @param cities Коллекция городов
     * @param fileName File name.
     */

    public ExecuteScriptFileName(LinkedList<City> cities, String fileName){
        this.cities = cities;
        this.fileName = fileName;
    }

    /**
     * Метод, запускающий выполнение команды.
     */

    @Override
    public void execute() throws Exception {
        if (Files.isReadable(Paths.get(fileName))) {
            Reflections reflections = new Reflections("Commands");
            Scannable fileScan = new FileScan(fileName);
            CommandsManager manager = new CommandsManager(cities);
            manager.fileCommands(fileScan).stream().filter(command -> !(command instanceof ExecuteScriptFileName)).forEach(command -> {
                try {
                    command.execute();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            });
        }
        throw new GetAccessException("Exception: No access for reading file");
    }

    /**
     * @return Command name.
     */

    public static String name() { return "execute_script"; }

    /**
     * @return Command information.
     */

    public static Information getInfo() throws Exception {
        return new Information(1,0,true,false, Arrays.asList("file name"), null);
    }

}
