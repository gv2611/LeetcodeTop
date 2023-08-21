package org.example.Hashmap;

import java.util.HashMap;

public class ContainsDuplicates2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i= 0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], i);
            }
            else if(hm.containsKey(nums[i])){
                int index = hm.get(nums[i]);
                if(Math.abs(index - i )<= k){
                    return true;
                }
                else{
                    hm.remove(nums[i]);
                    hm.put(nums[i], i);
                }
            }
        }
        return false;

    }
    public static void main(String [] args){
        ContainsDuplicates2 containsDuplicates = new ContainsDuplicates2();
        int num[] = {1,2,3,1};
        int num2[] = {1,2,3,1,2,3};
        int num3[] = {1,0,1,1};


        int k=3;
        System.out.println(containsDuplicates.containsNearbyDuplicate(num3,2));
    }
}
