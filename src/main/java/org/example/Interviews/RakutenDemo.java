package org.example.Interviews;

import java.util.HashMap;

public class RakutenDemo {

    public int solution(int[] A) {
        int firstPositiveInteger = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i<A.length;i++){
            hm.put(A[i], 0);
        }
        for(int i = 1;i<=100000;i++){
            if(!hm.containsKey(i)){
                firstPositiveInteger=i;
                break;
            }
        }
        return firstPositiveInteger;

        // Implement your solution here
    }

    public static void main(String args[]){
        RakutenDemo rakuten = new RakutenDemo();
        int arr[] = {1, 3, 6, 4, 1, 2};
        System.out.println(rakuten.solution(arr));
    }
}
