package system.fileSystem;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    public String readFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader(filename));
        return br.readLine();
    }
}
