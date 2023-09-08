package org.example.StringsArrays;

public class RotateArray {
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        if (k > len) {
            k = k % len;
        }
        int finalArray[] = new int[len];
        int pos = 0;
        for (int i = len - k; i < len; i++) {
            finalArray[pos] = nums[i];
            pos++;
        }

        for (int i = 0; i < len - k; i++) {
            finalArray[pos] = nums[i];
            pos++;
        }
        for (int i = 0; i < len; i++) {
            nums[i] = finalArray[i];
        }
        printArray(finalArray);
    }

    public void rotate3(int[] nums, int k) {
        int len = nums.length;

        if(k>len){
            k= k%len;
        }
        int limit = len-1;

        for(int i = 0;i<len;i++){
            int temp = nums[i];
            nums[i] = nums[len-k];
            int temp2 = nums[len-k-1];
            nums[len-k-1] = temp;
            nums[limit] = temp2;
            k--;
            limit--;
        }
        printArray(nums);

    }




        public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("," + arr[i]);
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int nums2[] = {-1, -100, 3, 99};
        int nums3[] = {1, 2, 3};

        int k = 3;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate3(nums, k);

    }
}
