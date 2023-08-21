package org.example;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        for(int i = 1 ; i<strs.length;i++){
            int minLen = Integer.min(lcp.length(), strs[i].length());
            int len =0;
            while (len!= minLen){
                if (strs[i].charAt(len) == lcp.charAt(len)){
                    len++;
                }
                else
                    break;
            }
            lcp = lcp.substring(0, len);
        }
        return lcp;
    }
    private static void printArray(String [] arrOutput) {
        for(int i = 0 ;i<arrOutput.length; i++){
            System.out.println(arrOutput[i]+" ");
        }
    }

    public static void main(String[] args){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] arr = {"dog","racecar","car"};
        System.out.println(lcp.longestCommonPrefix(arr));

    }
}
