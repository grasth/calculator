package com.company;

public class Match {
    public static Utils utils = new Utils();
    public static Parsing pars = new Parsing();
    int i = 0;
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
            updateStr(pars.getAct(result, action));
        }
        return result;
    }

    private void updateStr(String match) {
        try {
            i += 1;
            String[] temp = match.split("=");
            result = result.trim().replace(temp[0],temp[1]);
            System.out.println(i + ") " + match + " || " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
