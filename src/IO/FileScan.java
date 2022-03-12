package IO;

import java.io.FileReader;
import java.io.IOException;

public class FileScan implements Scannable {

    private FileReader reader;
    private boolean eof = false;

    public FileScan (FileReader reader) throws IOException {
        this.reader = reader;
        if (reader.read() == -1) {
            this.eof = true;
        }
        reader.reset();
    }

    @Override
    public Integer scanInteger() throws IOException {
        StringBuilder string = new StringBuilder();
        if (hasNextLine()) {
            while (true) {
                int ch = reader.read();
                char chr = (char) ch;
                if (chr == '\n' || chr == '\u0020' || ch == -1) {
                    if (ch == -1) {
                        eof = true;
                    }
                    break;
                }
                string.append(chr);
            }
        }
        return Integer.parseInt(string.toString());
    }

    @Override
    public Double scanDouble() throws IOException {
            StringBuilder string = new StringBuilder();
            if (hasNextLine()) {
                while (true) {
                    int ch = reader.read();
                    char chr = (char) ch;
                    if (chr == '\n' || chr == '\u0020' || ch == -1) {
                        if (ch == -1) {
                            eof = true;
                        }
                        break;
                    }
                    string.append(chr);
                }
            }
            return Double.parseDouble(string.toString());
    }

    @Override
    public String scanString() throws IOException {
        StringBuilder string = new StringBuilder();
        if (hasNextLine()) {
            while (true) {
                int ch = reader.read();
                char chr = (char) ch;
                if (chr == '\n' || ch == -1) {
                    if (ch == -1) {
                        eof = true;
                    }
                    break;
                }
                string.append(chr);
            }
        }
        return string.toString();
    }

    @Override
    public long scanLong() throws IOException {
        StringBuilder string = new StringBuilder();
        if (hasNextLine()) {
            while (true) {
                int ch = reader.read();
                char chr = (char) ch;
                if (chr == '\n' || chr == '\u0020' || ch == -1) {
                    if (ch == -1) {
                        eof = true;
                    }
                    break;
                }
                string.append(chr);
            }
        }
        return Long.parseLong(string.toString());
    }

    @Override
    public boolean hasNextLine() {
        return !eof;
    }
}
