package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private final Parsing pars = new Parsing();

    public char[] arrangeActions(char[] actions) {
        int j = 0;
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == '*' || actions[i] == '/') {
                char temp = actions[i];
                for (int l = i; l > j; l--) {
                    actions[l] = actions[l - 1];
                }
                actions[j] = temp;
                j++;
            }
        }
        return actions;
    }

    public String Move(char[] step, String example) throws Exception {

        System.out.println("Step count: " + step.length);
        String str = "";
        int i = 1;
        double result = 0;

        for (char ch : step) {
            Pattern pattern = Pattern.compile("(-|\\d+(?:[\\.,]\\d+)?)["+ ch +"](-|\\d+(?:[\\.,]\\d+)?)");
            Matcher match = pattern.matcher(example);
            while (match.find()) {
                str = match.group(0);

                result = pars.match(str, Character.toString(ch));

                example = example.replace(str, (result - (int) result == 0 || result + (int)result == 0? Integer.toString((int)result):Double.toString(result)));

                System.out.println(i + ": " + str + "\n" + example);
                break;
            }
            i++;
        }
        return example;
    }
}
//2*2/2+1+5/2+1.5
//1.6*9-10/2*7+1