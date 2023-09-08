package org.example.TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0; int right = s.length()-1;
        if(s.equals("")){
            return true;
        }
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)) {
                left++;
                right--;
            }
            else
                return false;
        }

        return true;
    }
    public static void main(String [] args){
        ValidPalindrome valid = new ValidPalindrome();
        System.out.println(valid.isPalindrome("aa"));
    }
}
