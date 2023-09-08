package org.example.Interviews;


// You are given a list of words in dictionary, and a list of input words, Find all the anagrams of input words from dictionary.

// dictwords =  ["cat", "dog", "tac", "god", "act", ]

// inputwords = ["cat" , "bat"]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RingCentral {

    public HashMap<String, ArrayList<String>> anagrams(String[] dictwords, String[] inputwords) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        for (int i = 0; i < inputwords.length; i++) {
            String word = inputwords[i];
            ArrayList<String> allAnagramsForAWord = new ArrayList<>();

            char wordToCheck[] = word.toCharArray();
            for (int j = 0; j < dictwords.length; j++) {
                String targetWord = dictwords[j];
                char target[] = targetWord.toCharArray();
                boolean isAnagram = areAnagrams(wordToCheck, target);
                if(isAnagram){
                    allAnagramsForAWord.add(new String(targetWord));
                }
            }
            hm.put(word, allAnagramsForAWord);
        }
        return hm;
    }

    private boolean areAnagrams(char[] wordToCheck, char[] target) {

        int n1 = wordToCheck.length;
        int n2 = target.length;

        if (n1 != n2) {
            return false;
        }

        Arrays.sort(wordToCheck);
        Arrays.sort(target);

        for (int i = 0; i < n1; i++) {
            if (wordToCheck[i] != target[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        RingCentral ring = new RingCentral();
        String[] dictwords = {"cat", "dog", "tac", "god", "act"};
        String[] inputwords = {"cat", "bat"};
        String[] dictwords2 = {"nap", "tap", "snap", "abc", "pat"};
        String[] inputwords2 = {"apt", "at"};
        System.out.println(ring.anagrams(dictwords2, inputwords2));
    }
}
