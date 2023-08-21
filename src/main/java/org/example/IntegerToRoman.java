package org.example;

import java.util.HashMap;

public class IntegerToRoman {
    public String intToRoman(int num) {

        int arr[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String arrString[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String str = "";
        while (num >= arr[arr.length-1]){
            str+= arrString[arrString.length-1];
            num = num - arr[arr.length-1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            while (num >= arr[i] && num < arr[i + 1]) {
                str += arrString[i];
                num = num - arr[i];
            }
        }
        return str;
    }


    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(2000));
    }
}
