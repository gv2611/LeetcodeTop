package org.example.Hashmap;

import java.util.HashMap;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> characterMapping = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }

        for(int i = 0; i<s.length();i++){
            if(!characterMapping.containsKey(s.charAt(i))){
                if(characterMapping.containsValue(t.charAt(i))){
                    return false;
                }
                else{
                    characterMapping.put(s.charAt(i), t.charAt(i));
                }
            }
            else if(characterMapping.containsKey(s.charAt(i))){
                if(!characterMapping.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
        }

        return true;


    }
    public static void main(String[] args){
        IsomorphicString isomorphic = new IsomorphicString();
        System.out.println(isomorphic.isIsomorphic("paperp", "titled"));
    }
}
