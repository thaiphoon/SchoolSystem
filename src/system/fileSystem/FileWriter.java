package system.fileSystem;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {

    public void writeToFile(String json, String filename) throws IOException {
        BufferedWriter br = new BufferedWriter(new java.io.FileWriter(filename));
        br.write(json);
        br.close();
    }
}
