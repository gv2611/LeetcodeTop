package org.example;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int limit = nums.length/2;
        int count = 1;
        int majorityElement=nums[0];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                count++;
                if(count>limit){
                    majorityElement = nums[i];
                    break;
                }
            }
        }
        return majorityElement;
    }

    public static void main(String args[]){
        int nums[] = {2,2,1,1,1,2,2};
        int nums2[] = {3,2,3};
        int nums3[]={-1,100,2,100,100,4,100};

        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums3));
    }
}
