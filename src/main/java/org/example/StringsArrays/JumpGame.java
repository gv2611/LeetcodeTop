package org.example.StringsArrays;

public class JumpGame {
    public boolean canJump(int[] arr) {
       // int bestOption = arr[0];

        if(arr.length == 1){
            return true;
        }
        if(arr[0] >= arr.length-1)
            return true;
        int i = 0;
        int init = 1;
        int limit = arr[0];
        int max_index=0;
        int max = Integer.MIN_VALUE;

        while(i < arr.length) {
            System.out.println("i=" + i);
            System.out.println("limit=" + limit);
            System.out.println("init=" + init);
            for (int j = init; j <= limit; j++) {
                if (arr[j] + j >= arr.length - 1) {
                    return true;
                } else if (j + arr[j] < arr.length) {
                    if (arr[j] + j >= max) {
                        max_index = j;
                        max = Integer.max(max, arr[j] + j);
                    }
                }
            }
            if (max_index >= arr.length - 1) {
                return true;
            }
            if(arr[max_index] == 0){
                return false;
            }
            i = max_index;
            limit = arr[i] + i;
            init = i+1;
        }
        return false;

    }

    public static void main (String [] args){
        JumpGame jump = new JumpGame();
        int arr[] = {2,3,1,1,4};
        int arr2[] = {3,2,1,0,4};
        int arr3 []= {0};
        int arr4[] ={1,2,3};
        int arr5[] ={1,1,1,0};
        int arr6[] = {3,0,8,2,0,0,1};

        System.out.println(jump.canJump(arr6));
    }
}
