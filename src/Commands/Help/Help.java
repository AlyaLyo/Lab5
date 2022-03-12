package Commands.Help;

import Commands.Commands;
import IO.Printable;
import IO.Scannable;

import java.io.IOException;


public class Help implements Commands {

    private Printable printable;
    private Scannable scannable;

    public Help (Printable printable, Scannable scannable) {
        this.scannable = scannable;
        this.printable = printable;
    }

    @Override
    public void execute() throws IOException {
        while (scannable.hasNextLine()) {
            printable.println(scannable.scanString());
        }

    }

}

