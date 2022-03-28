package IO;

import City.*;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class CSVManager {

    public static LinkedList<City> parse (String filename) throws Exception {
        LinkedList<City> cities = new LinkedList<>();
        CSVReader csvReader = new CSVReader(new FileReader(filename), ';');
        csvReader.readAll().forEach(line -> {
            cities.add(CityConstructor.parse(line));
        });
        return cities;
    }

    public static void toCSV(LinkedList<City> list) throws Exception {
        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter("collection.csv")), ';');
        list.forEach(elem -> {
            String [] collection = elem.toString().split(",");
            csvWriter.writeNext(collection);
        });
        csvWriter.close();
    }

}
