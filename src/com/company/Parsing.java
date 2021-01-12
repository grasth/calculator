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

    public double match(String first, String second, String move) throws Exception {
        switch (move) {
            case "*":
                return Math.round(actions.multiplication(Double.parseDouble(first), Double.parseDouble(second)) * 100) / 100D;
            case "/":
                return Math.round(actions.division(Double.parseDouble(first), Double.parseDouble(second)) * 100) / 100D;
            case "-":
                return Math.round(actions.subtraction(Double.parseDouble(first), Double.parseDouble(second)) * 100) / 100D;
            case "+":
                return Math.round(actions.addition(Double.parseDouble(first), Double.parseDouble(second)) * 100) / 100D;
            default:
                throw new Exception("Не ожиданная ошибка");
        }
    }

    public String getAct(String example, char action) throws Exception {
        Pattern pattern = Pattern.compile("(([-])?((\\d*([.]\\d+))|(\\d+)))[" + action + "](([-])?((\\d*([.]\\d+))|(\\d+)))");
        Matcher matcher = pattern.matcher(example);
        while (matcher.find()) {
            double matchAct = match(matcher.group(1), matcher.group(7), Character.toString(action));
            if (matchAct - (int) matchAct == 0 || matchAct + (int) matchAct == 0) {
                return matcher.group(1) + action + matcher.group(7) + "=" + (int)match(matcher.group(1), matcher.group(7), Character.toString(action));
            } else {
                return matcher.group(1) + action + matcher.group(7) + "=" + match(matcher.group(1), matcher.group(7), Character.toString(action));
            }
        }
        return null;

    }
}
