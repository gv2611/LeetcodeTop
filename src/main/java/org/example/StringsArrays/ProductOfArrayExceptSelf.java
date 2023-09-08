package org.example.StringsArrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countOfZero = 0;
        int productNoZero = 1;
        int output [] = new int[nums.length];
        for(int i = 0 ;i<nums.length;i++){
            product = product* nums[i];
            if(nums[i] == 0){
                countOfZero++;
            }
            if(nums[i] != 0){
                productNoZero= productNoZero*nums[i];
            }
        }
        for(int i = 0 ;i<nums.length;i++){
            if(product!=0){
                output[i] = product/nums[i];
                continue;
            }
            else if ( product==0 && nums[i]!=0){
                output[i] = 0;
            }
            else if( product==0 && nums[i] == 0 && countOfZero>1){
                output[i] = 0;

            }
            else if( product==0 && nums[i] == 0 && countOfZero==1){
                output[i] = productNoZero;

            }
        }
        return output;

    }

    private static void printArray(int[] arrOutput) {
        for(int i = 0 ;i<arrOutput.length; i++){
            System.out.println(arrOutput[i]+" ");
        }
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf prod = new ProductOfArrayExceptSelf();
        int arr[] = {3, 0, 6, 1, 5};
        int arr2[] = {1,2,3,4};
        int arr3[] = {-1,1,0,-3,3};

        int arrOutput[] = prod.productExceptSelf(arr2);
        printArray(arrOutput);
    }
}


