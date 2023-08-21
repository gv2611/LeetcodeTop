package org.example;

import java.io.*;
import java.util.*;


public class GlobalMaximum {
    public int findMaximum(List<Integer> arr, int m) {
        int n = arr.size();
        Collections.sort(arr);
        int start = 0;
        int end = arr.get(n-1) - arr.get(0);

        int ans = 0;

        while(start <= end){
            int mid = (start+end)/2;
            if (canBeSubsequence(arr, n, m, mid))
            {
                ans = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean canBeSubsequence(List<Integer> arr, int n, int m, int mid) {
        int count = 1;
        int last_position = arr.get(0);
        for(int i = 1; i < n; i++)
        {
            if (arr.get(i) - last_position >= mid)
            {
                last_position = arr.get(i);
                count++;
                if (count == m)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        GlobalMaximum global = new GlobalMaximum();
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,3,5,9));
        System.out.println(global.findMaximum(arr,3));



    }
}
