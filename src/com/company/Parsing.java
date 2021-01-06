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
                    queueMove[queueMove.length-1] = '*';
                    break;
                case '/':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length-1] = '/';
                    break;
                case '-':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length-1] = '-';
                    break;
                case '+':
                    queueMove = Arrays.copyOf(queueMove, queueMove.length + 1);
                    queueMove[queueMove.length-1] = '+';
                    break;
                default:
                    break;
            }
        }

        return queueMove;
    }

    public double match(String str, String move) throws Exception {
        String[] numbers = str.split(move);
        switch (str) {
            case "*":
                return actions.multiplication(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            case "/":
                return actions.division(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            case "-":
                return actions.subtraction(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            case "+":
                return actions.addition(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            default:
                throw new Exception("Не ожиданная ошибка");
        }
    }
}
