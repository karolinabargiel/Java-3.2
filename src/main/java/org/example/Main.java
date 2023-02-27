package org.example;

import static org.example.Configuration.getProperties;
import static org.example.Configuration.printProperties;

public class Main {

    public static void main(String[] args) {
        String[] sensitive = {"password", "login"};
        printProperties(getProperties(), sensitive);
    }

}