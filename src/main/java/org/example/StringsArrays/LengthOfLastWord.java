package org.example.StringsArrays;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String str[] = s.split(" ");
        return str[str.length-1].length();
    }

    public static void main(String[] args){
        LengthOfLastWord length = new LengthOfLastWord();
        System.out.println(length.lengthOfLastWord(""));
    }
}
