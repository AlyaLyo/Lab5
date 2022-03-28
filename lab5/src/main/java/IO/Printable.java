package IO;

import java.io.IOException;

public interface Printable {

    void println(String string) throws IOException;
    void print(String string) throws IOException;

}
