package org.example.SlidingWindow;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        Set<String> allCombinations = new HashSet<>();
        allCombinations = generateCombinations (words);
     //   System.out.println(allCombinations);
        int maxLen = words.length * words[0].length();
        int lenOfEachWord = words[0].length();
        List<Integer> indexes = new ArrayList<>();

        for(int i = 0 ;i<s.length()-lenOfEachWord;i+=lenOfEachWord){
            while(i+maxLen < s.length())
            {
                String sub = s.substring(i, i+maxLen);
                if(allCombinations.contains(sub)){
                    indexes.add(i);
                }
            }
        }
        return indexes;

    }

    private Set<String> generateCombinations(String[] words) {
        Set<String> allCombinations = new HashSet<>();
        for(int i = 0 ; i<words.length; i++){
            String s = words[i];
            for( int j= 0; j<words.length; j++){
                if(i !=j){
                     s = s+words[j];
                }
            }
            allCombinations.add(s);
        }
        return allCombinations;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        HashMap<String, Integer > hm = new HashMap<>();
        for(int i = 0 ; i<words.length;i++)
        {
            if(!hm.containsKey(words[i])){
                hm.put(words[i], 1);
            }
            else{
                int value = hm.get(words[i]);
                hm.remove(words[i]);
                value++;
                hm.put(words[i], value);
            }
        }
        Map<String, Integer> backup = copyMap(hm);
        int maxLen = words.length * words[0].length();
        int lenOfEachWord = words[0].length();

        int left = 0;
        int start = 0;
        int end = start + maxLen;
        int right = left+maxLen;
        List<Integer> list = new ArrayList<>();
        while(end <= s.length()){
            String sub = s.substring(start, end);
            while(left!= right) {
                String insideSub = sub.substring(left, left + lenOfEachWord);
                if (hm.containsKey(insideSub)) {
                    int value = hm.get(insideSub);
                    if (value > 1) {
                        value--;
                        hm.put(insideSub, value);
                    } else {
                        hm.remove(insideSub);
                    }
                    left = left + lenOfEachWord;
                }
                else
                    break;
            }
            if(hm.isEmpty()){
                list.add(start);
            }
            hm = (HashMap<String, Integer>) copyMap(backup);
            start = start+1;
            end = start + maxLen;
            left = 0;
            right = left + maxLen;
           // left = index;
         //   right = left+maxLen;
        }
        return list;
    }
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        Set<T> keys = new HashSet<T>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
    public static <K, V> Map<K, V> copyMap(Map<K, V> original)
    {
        Map<K, V> second_Map = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            second_Map.put(entry.getKey(),
                    entry.getValue());
        }
        return second_Map;
    }


    public static void main(String [] args){
        SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
        String [] words = {"foo","bar"};
        String[] words2={"fooo","barr","wing","ding","wing"};
        String s = "barfoothefoobarman";
        String s2= "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        System.out.println(substringwithConcatenationofAllWords.findSubstring2(s2, words2));
    }


}
