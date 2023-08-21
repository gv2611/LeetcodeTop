package org.example;

import java.util.Arrays;
import java.util.*;
import java.util.HashMap;

public class HIndex {

//    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given
//    researcher has published at least h papers that have each been cited at least h times.
  //  lenth of the array  == arr[i] ==
    public int hIndex(int[] citations) {
        int count = 0;
        int maxH= 0;
        int [] sortedCitations = sortDescending(citations);
        for(int i= 0; i<sortedCitations.length ;i++){
            if(sortedCitations[i] >=i+1){
                count++;
                maxH = Integer.max(maxH,count);
            }

        }
        return maxH;
    }

    public int[] sortDescending (int[] arr){
        Arrays.sort(arr);

        // Reverse the sorted array
        int[] descendingArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            descendingArr[i] = arr[arr.length - 1 - i];
        }
        return descendingArr;
    }



    public static void main(String[] args) {
        HIndex hindex = new HIndex();
        int arr[] = {3,0,6,1,5};
        int arr2[] = {1,3,1};
        int arr3[] = {11,15};
        //0,1,3,5,6
        System.out.println(hindex.hIndex(arr));
    }
}
