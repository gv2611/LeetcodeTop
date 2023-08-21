package org.example;

public class RemoveDuplicatesFromSorted {

    public int removeDuplicates(int[] nums) {
        int location =0;
        if(nums.length>0){
        int distinct = nums[0];
        for(int i=1; i<nums.length; i++){
            if(distinct == nums[i] ){
                continue;
            }
            else {
                location++;
                nums[location] = nums[i];
                distinct = nums[i];
            }
        }}
        printArray(nums);

        return location+1;
    }

    public static void printArray(int arr[])
    {
        for(int i =0 ;i< arr.length ; i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    public static void main(String [] args) {
        int nums[]= {0,0,1,1,1,2,2,3,3,4};
        int num2[]={1,1,2};
      //  int num1[] = {0,1,2,2,3,0,4,2};

        RemoveDuplicatesFromSorted removeDuplicatesFromSorted = new RemoveDuplicatesFromSorted();
        System.out.println(removeDuplicatesFromSorted.removeDuplicates(num2));
    }

}
