package com.company;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                return Math.round(actions.multiplication(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) * 100) / 100D;
            case "/":
                return Math.round(actions.division(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) * 100) / 100D;
            case "-":
                return Math.round(actions.subtraction(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) * 100) / 100D;
            case "+":
                return Math.round(actions.addition(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) * 100) / 100D;
            default:
                throw new Exception("Не ожиданная ошибка");
        }
    }

    public String getAct(String example, char action) {
        Pattern pattern = Pattern.compile("(([-])?((\\d*([.]\\d+))|(\\d+)))[" + action + "](([-])?((\\d*([.]\\d+))|(\\d+)))");
        Matcher matcher = pattern.matcher(example);
        while (matcher.find()) {
            return matcher.group(1) + action + matcher.group(7);
        }
        return null;

    }
}
