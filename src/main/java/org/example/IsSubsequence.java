package org.example;

import java.util.HashMap;
import java.util.regex.Pattern;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int lenS = s.length();
        int lenT = t.length();

        int i=0,j=0;

        while(i<lenS && j<lenT){

            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i==lenS;

    }

    public static void main(String [] args){
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }
}
