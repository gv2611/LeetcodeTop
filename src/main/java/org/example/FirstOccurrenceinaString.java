package org.example;

public class FirstOccurrenceinaString {
    public int strStr(String haystack, String needle) {
        int lenNeedle = needle.length();
//        if(haystack.equals(needle))
//            return 0;
        for(int i=0;i<=haystack.length()-lenNeedle;i++){
            if(haystack.substring(i,i+lenNeedle).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        FirstOccurrenceinaString fos = new FirstOccurrenceinaString();
        System.out.println(fos.strStr("a", "a"));

    }
}
