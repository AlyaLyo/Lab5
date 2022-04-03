package IO;

import City.City;
import City.CityConstructor;
import Exceptions.GetAccessException;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Класс, отвечающий за работу с файлами формата CSV.
 */

public class CSVManager {

    public void reader(String filename) throws FileNotFoundException {
        FileReader reader = new FileReader(filename);
    }

    public static LinkedList<City> parse (String filename) throws Exception {
        LinkedList<City> cities = new LinkedList<>();
        if (Files.isReadable(Paths.get(filename))) {
            CSVReader csvReader = new CSVReader(new FileReader(filename), ';');
            csvReader.readAll().forEach(line -> {
                cities.add(CityConstructor.parse(line));
            });
            return cities; }
        throw new GetAccessException("Exception: No access for reading file");
    }

    public static void toCSV(LinkedList<City> cities) throws Exception {
        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter("collection.csv")), ';');
        cities.forEach(elem -> {
            String [] collection = elem.toString().split(",");
            csvWriter.writeNext(collection);
        });
        csvWriter.close();
    }

}
