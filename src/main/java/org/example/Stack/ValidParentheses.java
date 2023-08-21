package org.example.Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> para = new Stack<>();

        for(int i =0 ; i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                para.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' || s.charAt(i)== ']' || s.charAt(i)=='}'){

                if(!para.isEmpty() && s.charAt(i) == ')' && para.peek()=='('){
                    para.pop();
                }
                else if(!para.isEmpty() && s.charAt(i) == ']' && para.peek()=='['){
                    para.pop();
                }
                else if(!para.isEmpty() && s.charAt(i) == '}' && para.peek()=='{'){
                    para.pop();
                }
                else {
                    return false;
                }

            }
        }
        if(para.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String [] args){
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("]"));
    }
}
