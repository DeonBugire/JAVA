package main;

import equation.EquationManager;

public class Main {
    public static void main(String[] args) {
        String filename = "equation.txt";
        EquationManager manager = new EquationManager(filename);
        manager.processEquationFile();
    }
}
