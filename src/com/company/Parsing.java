package com.company;

import java.util.Arrays;

public class Parsing {

    private static final Actions actions = new Actions();

    public char[] moves(String example) {
        example = example.replaceAll("\\s", "");
        char[] chars = example.toCharArray();
        char[] queueMove = new char[0];

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '*':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length - 1] = '*';
                    break;
                case '/':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length - 1] = '/';
                    break;
                case '-':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length - 1] = '-';
                    break;
                case '+':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length - 1] = '+';
                    break;
                default:
                    break;
            }
        }

        return queueMove;
    }

    public double match(String str, String move) throws Exception {

        String[] numbers = str.split("[" + move + "]");

        switch (move) {
            case "*":
                    return actions.multiplication(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
            case "/":
                    return actions.division(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
            case "-":
                    return actions.subtraction(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
            case "+":
                    return actions.addition(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
            default:
                throw new Exception("Не ожиданная ошибка");
        }
    }
}
