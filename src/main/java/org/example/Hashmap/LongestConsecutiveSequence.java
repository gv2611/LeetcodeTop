package org.example.Hashmap;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0 ; i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], i);
            }
        }
        int count = 1;
        int max = 0;
        for(int i = 0 ; i< nums.length;i++){
            int num = nums[i]+1;
            while(hm.containsKey(num)){
                count++;
                num = num+1;
            }
            max = Integer.max(max, count);
            count=1;
        }
        return max;

    }

    public static void main (String [] args){
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int nums[] = {100,4,200,1,3,2};
        int nums2[] ={};
        System.out.println(lcs.longestConsecutive(nums));
    }
}
