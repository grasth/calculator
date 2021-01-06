package com.company;

import java.util.Scanner;

public class Main {
    private static final Actions actions = new Actions();
    private static final Parsing parsing = new Parsing();
    private static final Validation validation = new Validation();
    private static final Utils util = new Utils();


    private static final Scanner consoleReader = new Scanner(System.in);
    private static String example;

    public static void main(String[] args) throws Exception {
        String result = "";
        System.out.print("Write your task: ");
        example = consoleReader.next();

        if (validation.validation(example)) {
            result = util.Move(util.arrangeActions(parsing.moves(example)), example);
        } else {
            throw new Exception("Error validation example");
        }

        System.out.println("Result: " + result);

    }
}
