package org.example.BackTracking;

import java.lang.reflect.Array;
import java.util.*;

public class LetterCombinationOfPhoneNumber {

//    public List<String> letterCombinations(String digits) {
//        HashMap<Character, List<Character>> hm = new HashMap<>();
//        hm.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
//        hm.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
//        hm.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
//
//        List<List<Character>> ch = new ArrayList<>();
//        char[] dig = digits.toCharArray();
//        for(int i = 0; i<dig.length;i++){
//            if(hm.containsKey(dig[i])){
//                ch.add(hm.get(dig[i]));
//            }
//        }
//        List<String> op = generateCombinations (dig.length, ch);
//        return null;
//
//
//
//    }

    static List<String> letterCombinations2(String number)
    {
        char ch[] = number.toCharArray();
        // table[i] stores all characters that
        // corresponds to ith digit in phone
        String[] table
                = { "0",   "1",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };

        ArrayList<String> list
                = letterCombinationsUtil(ch, ch.length, table);

        // Print the contents of the list
       return list;
    }

    static ArrayList<String>
    letterCombinationsUtil(char[] number, int n,
                           String[] table)
    {
        // To store the generated letter combinations
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.remove();

            // If complete word is generated
            // push it in the list
            if (s.length() == n)
                list.add(s);
            else {
                String val = table[number[s.length()]-'0'];
                for (int i = 0; i < val.length(); i++)
                {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }



    public static void main(String[] args){
        LetterCombinationOfPhoneNumber letters =  new LetterCombinationOfPhoneNumber();
        System.out.println(letters.letterCombinations2("23"));
    }

}
