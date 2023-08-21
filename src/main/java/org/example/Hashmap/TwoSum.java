package org.example.Hashmap;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] op = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],i );
        }

        for(int i =0 ;i<nums.length;i++){
            int remaining = target-nums[i];
            if(hm.containsKey(remaining) && hm.get(remaining)> i){
                op[0] = i;
                op[1] = hm.get(remaining);
            }
        }
        return op;
    }

    public void printArray (int [] arr){
        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args){
        TwoSum twosum = new TwoSum();
        int num[] = {3,3};
        int [] op =twosum.twoSum(num, 6);
        twosum.printArray(op);
    }

}
