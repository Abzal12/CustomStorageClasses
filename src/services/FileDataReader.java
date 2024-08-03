package src.services;

import custom_collections.CustomArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader {

    public static void fulfillListFromFile(String pathToData, CustomArrayList<String> names) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToData))) {
            String name;
            while ((name = bufferedReader.readLine()) != null) {
                names.put(name);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
