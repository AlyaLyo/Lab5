package IO;

import java.io.IOException;

/**
 * Interface scan classes.
 */

public interface Scannable {

    Integer scanInteger() throws IOException;
    Double scanDouble() throws IOException;
    String scanString() throws IOException;
    long scanLong() throws IOException;
    boolean hasNextLine();
}
