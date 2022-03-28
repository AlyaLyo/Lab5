package IO;

import java.util.Scanner;

public class ConsoleScan implements Scannable {

    private Scanner scanner;

    public ConsoleScan (Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Integer scanInteger() {
        return scanner.nextInt();
    }

    @Override
    public Double scanDouble() {
        return scanner.nextDouble();
    }

    @Override
    public String scanString() {
        return scanner.nextLine();
    }

    @Override
    public long scanLong() {
        return scanner.nextLong();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

}
