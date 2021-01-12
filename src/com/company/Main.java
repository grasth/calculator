package com.company;

import java.util.Scanner;

public class Main {
    private static final Validation validation = new Validation();
    private static final Scanner consoleReader = new Scanner(System.in);
    private static Match match = new Match();
    private static String example;

    public static void main(String[] args) throws Exception {
        String result = "";
        System.out.print("Write your task: ");
        example = consoleReader.next();

        if (validation.validation(example)) {
            System.out.println("Result: " + match.Calculation(example));
        } else {
            throw new Exception("Error validation example");
        }


    }
}
