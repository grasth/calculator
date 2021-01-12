package com.company;

public class Validation {
    public boolean validation(String example) throws Exception {
        example = example.replaceAll("\\s", "");
        char[] chars = example.toCharArray();
        for (int i=0; i < chars.length;i++) {
            if(Character.isLetter(chars[i])) {
                return false;
            }
            if(!Character.isDigit(chars[i])){
                for (char ch:chars) {
                    if(ch == chars[i]){
                        if (i < chars.length && ch == chars[i+1]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
