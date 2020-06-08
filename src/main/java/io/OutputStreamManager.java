package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStreamManager {

    public static void appendToFile(String value, String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(value + "\n");
        fw.close();
    }

    public static void appendToFileWithBuffered(String value, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

        writer.write(value);
        writer.newLine();

        writer.flush();
        writer.close();
    }
}
