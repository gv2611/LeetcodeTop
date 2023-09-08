package org.example.StringsArrays;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);
        int number = 0;
        char [] ch = s.toCharArray();
        for(int i = 0; i < ch.length-1; i++){
            if(romanToInteger.containsKey(ch[i])){
                if(romanToInteger.get(ch[i]) < romanToInteger.get(ch[i+1])){
                    number-=romanToInteger.get(ch[i]);
                    continue;
                }
                number += romanToInteger.get(ch[i]);
            }
        }
        number+= romanToInteger.get(ch[ch.length-1]);
        return number;
    }

    public static void main(String [] args){
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("LVIII"));

    }
}
