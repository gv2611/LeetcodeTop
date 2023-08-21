package org.example;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int location=1;
        int distinct = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] == distinct){
                count++;
            }
            else {
                distinct = nums[i];
                count=1;
            }
            if(count <= 2){
                nums[location] = distinct;
                location++;
            }
        }
        printArray(nums);
        return location;
    }

      public static void printArray(int arr[])
      {
        for(int i =0 ; i< arr.length ; i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    public static void main(String [] args) {
        int nums[] = {0,0,1,1,1,1,1,2,2,3,3,4};
        int num2[] = {1,1,2};
        RemoveDuplicates removeDuplicates= new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
}
