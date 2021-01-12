package com.company;

public class Match {
    public static Actions actions = new Actions();
    public static Utils utils = new Utils();
    public static Parsing pars = new Parsing();
    int i = 1;
    private String result = "";

    public String Calculation(String example) throws Exception {
        result = example;
        char[] queueMove = arrangeActions(example.replaceAll("\\s", ""));
        return Calculate(queueMove);
    }

    private char[] arrangeActions(String example) {
        return utils.arrangeActions(pars.moves(example));
    }

    private String Calculate(char[] queueMove) throws Exception {
        for (char action : queueMove) {
            updateStr(pars.getAct(result, action), action);
        }
        return result;
    }

    private void updateStr(String match, char action) throws Exception {
        try {
            double matchAct = pars.match(match, Character.toString(action));
            if (matchAct - (int) matchAct == 0) {
                result = result.replace(match, Integer.toString((int) pars.match(match, Character.toString(action))));

                System.out.println(i + ") " + match + "=" + (int) matchAct + "\s||\s" + result);
            } else {
                result = result.replace(match, Double.toString(pars.match(match, Character.toString(action))));
                System.out.println(i + ") " + match + "=" + matchAct + "\s||\s" + result);
            }
            i++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
