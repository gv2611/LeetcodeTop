package org.example.Hashmap;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> strList = new ArrayList<>();
        for(int i = 0; i<strs.length;i++){
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if(!hm.containsKey(tempStr)){
                hm.put(tempStr, new ArrayList<>(Arrays.asList(strs[i])));
            }
            else{
                hm.get(tempStr).add(strs[i]);
            }
        }
        for(Map.Entry<String , List<String>> entry : hm.entrySet()){
            List<String> values = entry.getValue();
            strList.add(values);
        }

        return strList;


    }

    public static void main(String [] args){
        GroupAnagrams group = new GroupAnagrams();
        String [] str = {"eat","tea","tan","ate","nat","bat"};
        String [] str2 = {"a"};

        System.out.println(group.groupAnagrams(str2));
    }

}
