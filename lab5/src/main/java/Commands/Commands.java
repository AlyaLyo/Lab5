package Commands;

import java.io.IOException;

/**
 * Интерфейс - предок всех команд.
 */

public interface Commands {

    void execute() throws IOException, Exception;

    static int[] argumentsAmount() {
        return new int[0];
    }

}
