package org.example.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }

        int[] range = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]);
        }

        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[] {start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[] {start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }

    private int[][] convertToArray(ArrayList<ArrayList<Integer>> op) {
        int output [][] = new int[op.size()][op.get(0).size()];
        for(int i = 0; i<op.size(); i++){
            for(int j=0; j< op.get(0).size(); j++){
                output[i][j] = op.get(i).get(j);
            }
        }
        return output;
    }


    public static void main(String[] args){
        MergeIntervals merge = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1,4},{0,0}};
        //[1,2],[3,5],[6,7],[8,10],[12,16]
        int [][] intervals3 = {{1,2},{3,5},{6,7},{8,10},{12,16},{4,8}};
        int [][] intervals4 = {{10,16},{2,8},{1,6},{7,12}};
        int[][] output = merge.merge(intervals4);
        merge.printArray(output);
    }

    private void printArray(int[][] output) {
        for(int i = 0; i< output.length; i++){
            for(int j = 0 ;j< output[0].length;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }
}
