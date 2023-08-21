package org.example.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int count = hm.getOrDefault(ch, 0);
            hm.put(ch, count + 1);
        }
        HashMap<Character, Integer> backup = (HashMap<Character, Integer>) copyMap(hm);
        System.out.println(hm);
        int start = 0, right = 0;
        String str = "";
        int end = s.length() - 1;
        String maxStr = "ADOBECODEBANCA";

        while (start <= s.length() && right< s.length()) {
            if (!hm.containsKey(s.charAt(right))) {
                if (t.length() > hm.size()) {
                    str += s.charAt(right);
                }
            } else {
                if(!hm.isEmpty()) {
                    int value = hm.get(s.charAt(right));
                    if(value > 1){
                        value--;
                        hm.remove(s.charAt(right));
                        hm.put(s.charAt(right), value);
                    }
                    else{
                        hm.remove(s.charAt(right));
                    }

                    str += s.charAt(right);
                }
            }
            if (hm.isEmpty()) {
                start++;
             //   s = s.substring(start, end);
                right = start;

            }
            if (str.length() < maxStr.length() && hm.isEmpty()) {
                maxStr = str;
                hm = (HashMap<Character, Integer>) copyMap(backup);
                start++;
                right = start;
                str="";
            }
            if(hm.isEmpty()){
                str="";
                right = start;

                hm = (HashMap<Character, Integer>) copyMap(backup);
            }
            else if(!hm.isEmpty())
                right++;
        }

        if(maxStr.equals("ADOBECODEBANCA")){
            return "";
        }
        return maxStr;

    }

    public static <K, V> Map<K, V> copyMap(Map<K, V> original) {
        Map<K, V> second_Map = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            second_Map.put(entry.getKey(),
                    entry.getValue());
        }
        return second_Map;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minWindow = new MinimumWindowSubstring();
        System.out.println(minWindow.minWindow("bdab", "ab"));
    }
}
