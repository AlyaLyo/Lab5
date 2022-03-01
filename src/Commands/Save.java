package Commands;

import City.City;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class Save implements Commands{

    private LinkedList<City> cities;

    @Override
    public void execute() {
        //Files.createFile(Path.of("C:\\Users\\Алёна\\Desktop\\прога\\lab5\\cities.txt"));
        //for (City city : cities) {
        //    Files.writeString(Path.of("C:\\Users\\Алёна\\Desktop\\прога\\lab5\\cities.txt"),"");
        //}
    }

}
