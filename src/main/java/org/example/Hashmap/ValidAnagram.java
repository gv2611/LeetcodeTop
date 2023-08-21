package org.example.Hashmap;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        hm.put(c, hm.getOrDefault(c, 0) + 1);
    }
    for(int i = 0; i<t.length();i++){
        char c = t.charAt(i);
        if (hm.containsKey(c)) {
            int value = hm.get(c);
            value--;
            if(value>0){
                hm.remove(c);
                hm.put(c, value);
            }
            else{
                hm.remove(c);
            }
        }
        else{
            return false;
        }
    }
    if(!hm.isEmpty()){
        return false;
    }
    return true;

}

    public static void main(String[] args){
        ValidAnagram anagram = new ValidAnagram();
        System.out.println(anagram.isAnagram("a", "ab"));
    }

}
