package main;

import equation.EquationManager;

public class Main {
    public static void main(String[] args) {
        EquationManager manager = new EquationManager("equations.txt");
        manager.processEquationFile();
    }
}