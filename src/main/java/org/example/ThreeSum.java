package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> eachEntry;
        Arrays.sort(nums);
        for(int i = 0 ;i<nums.length-1;i++){
            list=findTwoSum(list, nums ,nums[i],i+1, nums.length-1);
        }
        return list;
    }

    private List<List<Integer>> findTwoSum(List<List<Integer>> list, int[] nums, int target, int start, int end) {
        while(start != end && start<end){
            if(nums[start]+nums[end] < target*-1){
                start++;
            }
            else if(nums[start]+nums[end] > target*-1){
                end--;
            }
            else if(nums[start]+nums[end] == target*-1){
                List<Integer> twoSum = new ArrayList<>();
                twoSum.add(target);
                twoSum.add(nums[start]);
                twoSum.add(nums[end]);
                if(twoSum.size()>0 && !list.contains(twoSum)){
                    list.add(twoSum);
                }
                start++;
                end--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum three = new ThreeSum();
        int arr[] = {-2,0,1,1,2};
        int arr2[]={0,0,0,0};
//        List<List<Integer>> list = new ArrayList<>();
//        list = three.threeSum(arr);
        System.out.println(three.threeSum(arr2));


    }
}
