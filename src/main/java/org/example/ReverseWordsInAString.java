package org.example;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String str [] = s.split(" ");
        String finalStr = "";
        for(int i = str.length-1; i>=0;i--){
            if(!str[i].equals("")) {
                String strHere = str[i].trim();
                finalStr += strHere + " ";
            }
        }
        finalStr = finalStr.trim();
        return finalStr;
    }
    public static void main(String [] args){
        ReverseWordsInAString reverse = new ReverseWordsInAString();
        System.out.println(reverse.reverseWords("a good   example"));
    }
}
