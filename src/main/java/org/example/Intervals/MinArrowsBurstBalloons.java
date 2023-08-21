package org.example.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        int count = 1;
        int end = points[0][1];

        for(int i =1 ;i<points.length;i++){
            if(!(points[i][0] <= end)){
                end = points[i][1];
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args){
        MinArrowsBurstBalloons minArrows = new MinArrowsBurstBalloons();
        //[[10,16],[2,8],[1,6],[7,12]]
        int points[][] = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(minArrows.findMinArrowShots(points));
    }

}
