package org.example.Intervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0){
            int[][] newIntervalArray = { {newInterval[0], newInterval[1]} };
            return newIntervalArray;
        }


        int row = intervals.length;
        int column = intervals[0].length;
        int[][] newArray = new int[row+1][column];
        newArray = copyArray(intervals, newArray);
        newArray[row][0] = newInterval[0];
        newArray[row][1] = newInterval[1];
        int output [][] = merge(newArray);
        return output;
    }

    private int[][] copyArray(int[][] intervals, int[][] newArray) {
        for(int i = 0;i<intervals.length;i++){
            for(int j=0;j<intervals[0].length;j++){
                newArray[i][j] = intervals[i][j];
            }
        }
        return newArray;
    }

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

    private void printArray(int[][] output) {
        for(int i = 0; i< output.length; i++){
            for(int j = 0 ;j< output[0].length;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        InsertInterval insertInterval = new InsertInterval();
        int [][] intervals = {{1,3}, {6,9}};
        int [][] intervals3 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {2,5};
        int[] newInterval3= {4,8};
        int output [][] = insertInterval.insert(intervals3, newInterval3);
        insertInterval.printArray(output);
    }
}
