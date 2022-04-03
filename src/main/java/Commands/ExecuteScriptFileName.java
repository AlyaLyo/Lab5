package Commands;

import City.City;
import IO.FileScan;
import IO.Printable;
import IO.Scannable;
import org.reflections.Reflections;

import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Считывает и исполняет скрипт из указанного файла.
 */

public class ExecuteScriptFileName implements Commands {

    private LinkedList<City> cities;
    private String fileName;
    private Printable printable;

    public ExecuteScriptFileName(LinkedList<City> cities, String fileName, Printable printable){
        this.cities = cities;
        this.fileName = fileName;
        this.printable = printable;
    }

    @Override
    public void execute() throws Exception {
        Reflections reflections = new Reflections("Commands");
        FileReader reader = new FileReader(fileName);
        Scannable fileScan = new FileScan(reader);
        CommandsManager manager = new CommandsManager(cities);
        manager.fileCommands(fileScan).stream().filter(command -> !(command instanceof ExecuteScriptFileName)).forEach(command -> {
            try {
                command.execute();
            } catch (Exception exception) {
                exception.getMessage();
            }
        });

    }


    public static String name() { return "execute_script"; }

    public static Information getInfo() throws Exception {
        return new Information(1,0,true,false, Arrays.asList("file name"), null);
    }

}
