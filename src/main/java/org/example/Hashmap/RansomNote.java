package org.example.Hashmap;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if (!hm.containsKey(c) || hm.get(c) <= 0) {
                return false;
            }
            hm.compute(c, (key, value) -> value - 1);
        }
        return true;

    }

    public static void main(String[] args){
        RansomNote ransom = new RansomNote();
        System.out.println(ransom.canConstruct("aa", "aa"));
    }
}
