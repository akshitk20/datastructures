package com.practice.leetcode.strings;

public class GoalParserInterpretation {
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }

    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < command.length() ; i++){
            if(command.charAt(i) == '(' || command.charAt(i) == 'a'){
                if(command.charAt(i+1) == 'a')
                    result.append('a');
                else if(command.charAt(i+1) == ')')
                    result.append('o');
                else if(command.charAt(i+1) == 'l')
                    result.append(command.charAt(i+1));
            }else if(command.charAt(i) == 'G')
                result.append(command.charAt(i));
        }

        return result.toString();
    }
}
