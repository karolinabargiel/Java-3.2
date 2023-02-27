package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {

    public static void printProperties(Map<String, String> properties, String[] sensitive) {
        properties.entrySet().stream()
                .map(entry -> {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (Arrays.asList(sensitive).contains(key)) {
                        value = "*****";
                    }
                    return key + ": " + value;
                })
                .forEach(System.out::println);
    }

    public static HashMap<String, String> getProperties() {
        Properties prop = new Properties();
        HashMap<String, String> map = new HashMap<>();
        try (InputStream input = new FileInputStream("C:\\Users\\kbargiel_adm\\IdeaProjects\\Java3.2\\src\\main\\java\\data\\data.properties")) {
            prop.load(input);
        } catch (IOException fxe) {
            System.out.println("Couldn't load properties correctly: " + fxe.getMessage());
        }
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());

        }
        return map;
    }
}
