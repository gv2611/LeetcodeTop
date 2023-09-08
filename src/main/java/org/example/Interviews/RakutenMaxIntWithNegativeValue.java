package org.example.Interviews;

import java.util.Arrays;


//Write a function solution that, given an artay A of integers, retuns the largest integer K>0
//        such that both values K and -K (the opposite number) exist in array A. If there is no such integer,
//        the function should return 0.
//
//        Examples:
//
//        1. Given A =[3,2, 2, 5, -3], the function should return 3 (both 3 and -3 exist in array A).
//        2.Given A =[1,1,2,-1,2, ~1], the function should return 1 (both 1 and -1 exist in array A).
//        3.Given A = 1, 2, 3, -4], the function should return 0 (there is no such K for which both values K
//        and -K exist in array A).
//
//        Write an efficient algorithm for the following assumptions:
//        « Nis an integer within the range [1..100,000];
//        « each element of array A is an integer within the range
//        [-1,000,000,000..,000,000,000].

public class RakutenMaxIntWithNegativeValue {
    public int solution2(int[] arr){
        int res = 0;
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == 0) {
                res = Math.max(
                        res, Math.max(
                                arr[l], arr[r]));
                return res;
            }
            else if (sum < 0) {
                l++;
            }
            else {
                r--;
            }
        }
        return res == 0 ? 0 : res;
    }
    public static void main(String args[]){
        int arr[] = {3,2,-2,5,-3};
        int arr2[] = {1,1,2,-1,2,-1};
        int arr3[] = {1,2,3,-4};

        RakutenMaxIntWithNegativeValue raku = new RakutenMaxIntWithNegativeValue();
        System.out.println(raku.solution2(arr3));
    }
}
