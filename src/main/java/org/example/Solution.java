package org.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    // Complete the packNumbers function below.
    static List<String> packNumbers(List<Integer> array) {
        List<String> result = new ArrayList<>();
        int length = array.size();
        int count = 1;
        for (int i=0; i<length;i++){
            if(i < length - 1 && array.get(i).equals(array.get(i+1))){
                count++;
            } else {
                if(count > 1) {
                    result.add(array.get(i)+":"+count);
                } else {
                    result.add(String.valueOf(array.get(i)));
                }
                count = 1;
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        List <Integer> array = new ArrayList<>(Arrays.asList(255,255,67,12,12,12));
        Solution sol = new Solution();
        System.out.println(sol.packNumbers(array));

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = new ArrayList<>();
//
//        for (int i = 0; i < arrCount; i++) {
//            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
//            arr.add(arrItem);
//        }
//
//        List<String> res = packNumbers(arr);
//
//        for (int i = 0; i < res.size(); i++) {
//            bufferedWriter.write(res.get(i));
//
//            if (i != res.size() - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
