package org.example.Stack;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<tokens.length;i++){
            if(!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*"))){
                stack.push(Integer.valueOf(tokens[i]));
            }
            else{

                int first  = stack.pop();
                int second = stack.pop();
                int result = 0;
                if(tokens[i].equals("+") ){
                    result = first+second;
                }
                if(tokens[i].equals("-") ){
                    result = second-first;
                }
                if(tokens[i].equals("/") ){
                    result = second/first;
                }
                if(tokens[i].equals("*") ){
                    result = first*second;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public static void main(String [] args){
        ReversePolishNotation reverse = new ReversePolishNotation();
        String[] str1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] str2 = {"4","13","5","/","+"};
        System.out.println(reverse.evalRPN(str2));
    }
}
