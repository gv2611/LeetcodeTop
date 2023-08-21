package org.example;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int arrOutput[] = new int[2];

        for(int i = 0; i< numbers.length;i++){
            if (!hm.containsKey(numbers[i])){
                hm.put(numbers[i], i);
            }
        }

        for(int i = 0 ;i<numbers.length;i++){
            if(hm.containsKey(target-numbers[i]) && i!=hm.get(target-numbers[i])){
                arrOutput[1] = i+1;
                arrOutput[0] = hm.get(target-numbers[i])+1;
            }
        }
        return arrOutput;

    }
    private static void printArray(int[] arrOutput) {
        for(int i = 0 ;i<arrOutput.length; i++){
            System.out.println(arrOutput[i]+" ");
        }
    }
    public static void main(String [] args){
        TwoSum twosum = new TwoSum();
        int arr[] = {-1,0};
        int output[] = twosum.twoSum(arr, -1);
     //   printArray(arr);
        printArray(output);
    }

    }
