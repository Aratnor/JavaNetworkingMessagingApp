package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class InputStreamManager {

    public static String getStringFromFile(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);

        int nextByte;

        StringBuilder builder = new StringBuilder();
        while((nextByte = fileInputStream.read()) != -1) {
            builder.append((char)nextByte);
        }

        fileInputStream.close();
        return builder.toString();
    }

    public static String getStringFromFileWithReader(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);

        int nextByte;

        StringBuilder builder = new StringBuilder();

        while((nextByte = reader.read()) != -1) {
            builder.append((char)nextByte);
        }

        reader.close();
        return builder.toString();
    }

    public static String getStringFromBufferedReader(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;

        StringBuilder builder = new StringBuilder();

        while((line = reader.readLine()) != null) {
            builder.append(line);
        }

        reader.close();
        return builder.toString();
    }
}
