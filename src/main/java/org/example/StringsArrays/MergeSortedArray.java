package org.example.StringsArrays;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count =0;
        for (int i = m-n ;i < m; i++ ){
            nums1[i] = nums2[count];
            count++;
        }
        Arrays.sort(nums1);
        printArray(nums1);

    }

    public static void printArray(int arr[])
    {
        for(int i =0 ;i< arr.length ; i++)
        {
            System.out.print(","+arr[i]);
            System.out.println();
        }
    }
    public static void main(String [] args){
       // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int num1[] = {1};
        int num2[] = {};
        int lenNum1 = num1.length;
        int lenNum2 = num2.length;
        int m = lenNum1+lenNum2;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(num1, lenNum1, num2, lenNum2);
}
}
