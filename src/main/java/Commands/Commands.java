package Commands;

import java.io.IOException;

/**
 * Interface commands.
 */

public interface Commands {

    void execute() throws IOException, Exception;

    static int[] argumentsAmount() {
        return new int[0];
    }

}
