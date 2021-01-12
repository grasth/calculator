package com.company;

public class Utils {
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
}