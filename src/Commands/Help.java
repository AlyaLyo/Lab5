package Commands;

import City.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Help implements Commands {

    @Override
    public void execute() {
        Scanner scanner = null;
        File file = new File("C:\\Users\\Алёна\\Desktop\\прога\\lab5\\help.txt");
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                System.out.println(string);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        }
    }

