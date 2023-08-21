package org.example;

import java.util.ArrayList;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i= 0;i<nums.length;i++)
        {
            if(nums[i]==val)
            {
                arrayList.add(i);
            }
        }
        System.out.println(arrayList);
        int lastElement = nums.length-1;
        for(int i= 0; i< nums.length;i++){
            if(arrayList.contains(lastElement)){
                //arrayList.remove(lastElement);
                arrayList.remove(Integer.valueOf(lastElement));
                lastElement--;
                count++;
            }
            if(nums[i]== val && !arrayList.contains(lastElement)&& lastElement>i) {
                int temp = nums[i];
                nums[i] = nums[lastElement];
                nums[lastElement] = temp;
                lastElement --;
                count++;
            }
            else continue;
        }

        printArray(nums);
        return nums.length-count;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
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
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int num1[] = {0,1,2,2,3,0,4,2};

        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement2(num1, 2));
    }
}
