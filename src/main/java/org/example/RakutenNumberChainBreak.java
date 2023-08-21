package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

//
//All we can do is to break the chain in exactly two non-adjacent positions. More precisely, we
//        should break links P,Q (0< P<Q<N - 1,Q - P > 1), resulting in three chains [0,P - 1], [P +1,Q
//        -1],[Q+1,N - 1]. The total cost of this operation is equal to A[P] + AlQ].
//
//        For example, consider array A such that:
//
//        A[0]
//        A[1]
//        A[2]
//        A[3]
//        A[4]
//        A[5]
//
//        We can choose to break the following Ii
//
//        [RN
//        Nwosny
//
//        (1,4): total costis2+3=5
//        (2,4): total costis 4 +3=7
//
//        . fi | total costis 2+ 6=8
//        Write a function:
//class Solution { public int solution(int(] A); }
//
//that, given an array A of N integers, returns the minimal cost of dividing chain into three pieces.
//
//        For example, given:
//        A[0]
//        A[1]
//        A[2]
//        A[3]
//        A[4]
//        A[5]
//
//        the function should return 5, as explained above.
//
//        wn nn
//        Nwosny
//
//        Write an efficient algorithm for the following assumptions:
//
//        « Nis an integer within the range [5..100,000];
//        + each element of array A is an integer within the range [1..1,000,000,000].
class RakutenNumberChainBreak {
    public static int cost(int A[]) {
        int N = A.length;
        int[] minRight = new int[N];
        minRight[N-2] = A[N-2];
        for (int i = N-3; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], A[i]);
        }
        int minCost = A[0];
        for (int p = 1; p <= N-3; p++) {
            int cost = A[p] + minRight[p+2];
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int arr[] = {5,2,4,6,3,7 };
        System.out.println(cost(arr));
    }
}