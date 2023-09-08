package org.example.StringsArrays;

public class JumpGame2 {
    public int jump(int[] arr) {
        // int bestOption = arr[0];

        if(arr.length == 1){
            return 0;
        }
        if(arr[0] >= arr.length-1)
            return 1;
        int i = 0;
        int init = 1;
        int limit = arr[0];
        int max_index=0;
        int max = Integer.MIN_VALUE;
        int jumps = 0;

        while(i < arr.length) {
            for (int j = init; j <= limit; j++) {
                if (arr[j] + j >= arr.length - 1) {
                    return jumps+2;
                } else if (j + arr[j] < arr.length) {
                    if (arr[j] + j >= max) {
                        max_index = j;
                        max = Integer.max(max, arr[j] + j);
                    }
                }
            }
            if (max_index >= arr.length - 1) {
                return jumps;
            }
            if(arr[max_index] == 0){
                return -1;
            }
            i = max_index;
            jumps++;
            limit = arr[i] + i;
            init = i+1;
        }
        return jumps;

    }

    public static void main (String [] args){
        JumpGame2 jump2 = new JumpGame2();
        int arr[] = {2,3,1,1,4};
        int arr2[] = {3,2,1,0,4};
        int arr3 []= {0};
        int arr4[] ={1,2,3};
        int arr5[] ={1,1,1,0};
        int arr6[] = {3,0,8,2,0,0,1};

        System.out.println(jump2.jump(arr6));
    }
}
