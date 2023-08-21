package org.example;

import java.util.HashMap;
import java.util.Map;

public class Algonomy {
    public String convert(int number) {
        HashMap<Integer, String> numberString = new HashMap<>();
        int digit = 0;
        int backup = number;
        String numberToString = "";
        numberString.put(1, "one");
        numberString.put(2, "two");
        numberString.put(3, "three");
        numberString.put(4, "four");
        numberString.put(5, "five");
        numberString.put(6, "six");
        numberString.put(7, "seven");
        numberString.put(8, "eight");
        numberString.put(9, "nine");
        numberString.put(0, "zero");
        numberString.put(-1, "one");
        numberString.put(-2, "two");



        if (number == 0) {
            return numberString.get(0);
        }
//        if(number<0){
//        number = number*-1;}
        while (number != 0) {
            digit = number % 10;
            String val = numberString.get(digit);
            numberToString = val + " " + numberToString;
            number = number / 10;
        }
        if (backup < 0) {
            numberToString = "minus " + numberToString;
        }
        return numberToString;
        //minus one zero

//        for(Map.Entry<Integer,String> entry: numberString.entrySet())
//            System.out.println("key = "+entry.getKey()+"value = "+entry.getValue());
    }

    public static void main(String args[]) {
        Algonomy algo = new Algonomy();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        System.out.println(min);
        System.out.println(max);

        System.out.println(algo.convert(min));
    }

}
