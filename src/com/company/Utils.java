package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public char[] arrangeActions(char[] actions){
        int j=0;
        for(int i=0; i< actions.length; i++){
            if(actions[i] == '*' || actions[i] == '/'){
               char temp = actions[i];
               for(int l =i; l > j; l--){
                   actions[l] = actions[l-1];
               }
               actions[j] = temp;
               j++;
            }
        }
        return actions;
    }

    public void Move(char[] step, String example) throws Exception {
        System.out.println("Step count: " + step.length);
        String str = "";
        int i =1 ;
        for (char ch:step) {
            Pattern pattern = Pattern.compile("(\\d+[" + ch +"]\\d+)");
            Matcher match = pattern.matcher(example);
            while (match.find()){
                str = match.group(0);
                example = example.replace(str, Integer.toString(i));
                System.out.println(i + ": " + str + "\n" + example);
                break;
            }
            i++;
        }
    }
}
