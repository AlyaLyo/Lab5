package Commands;

import City.City;
import IO.FileScan;
import IO.Scannable;

import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Считывает и исполняет скрипт из указанного файла.
 */

public class ExecuteScriptFileName implements Commands {

    private LinkedList<City> cities;
    private String fileName;

    public ExecuteScriptFileName(LinkedList<City> cities, String fileName){
        this.cities = cities;
        this.fileName = fileName;
    }

    @Override
    public void execute() throws Exception {
        FileReader reader = new FileReader(fileName);
        Scannable fileScan = new FileScan(reader);
        CommandsManager manager = new CommandsManager(cities);
        for (Commands command : manager.fileCommands(fileScan)) {
            command.execute();
        }
    }

    public static String name() { return "execute_script_file_name"; }

    public static Information getInfo() throws Exception {
        return new Information(1,0,true,false, Arrays.asList("file name"), null);
    }

}
