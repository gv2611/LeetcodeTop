package org.example.Intervals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> al=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int start=nums[i];
             while(i+1<nums.length && nums[i]+1==nums[i+1])
                i++;

            if(start!=nums[i]){
                al.add(""+start+"->"+nums[i]);
            }
            else{
                al.add(""+start);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        SummaryRanges summary = new SummaryRanges();
        int[] arr = {0,2,3,4,6,8,9};
        List<String> list = summary.summaryRanges(arr);
        System.out.println(list);


    }
}
