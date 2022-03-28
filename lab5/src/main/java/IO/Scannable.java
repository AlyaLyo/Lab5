package IO;

import java.io.IOException;

public interface Scannable {

    Integer scanInteger() throws IOException;
    Double scanDouble() throws IOException;
    String scanString() throws IOException;
    long scanLong() throws IOException;
    boolean hasNextLine();
}
