package org.example.Interviews.groupon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDifference {

    public static int maxDifference(List<Integer> px) {
        if (px == null || px.isEmpty()) {
            return -1; // No data to analyze, return -1 as per the problem statement.
        }

        int minPrice = px.get(0); // Initialize the minimum price to the first day's price.
        int maxSpread = -1; // Initialize the maximum positive spread to -1 as a sentinel value.

        for (int i = 1; i < px.size(); i++) {
            int currentPrice = px.get(i);

            if (currentPrice < minPrice) {
                minPrice = currentPrice; // Update the minimum price if a lower price is encountered.
            } else {
                int spread = currentPrice - minPrice;
                if (spread > maxSpread) {
                    maxSpread = spread; // Update the maximum positive spread if a larger spread is found.
                }
            }
        }

        return maxSpread;

    }

    int maxDiff2(List<Integer> px)
    {
        int max_diff = px.get(1) - px.get(0);
        int min_element = px.get(0);
        int i;
        for (i = 1; i < px.size(); i++)
        {
            if (px.get(i) - min_element > max_diff)
                max_diff = px.get(i) - min_element;
            if (px.get(i) < min_element)
                min_element = px.get(i);
        }

        return max_diff;
    }

    public static void main(String[] args){
        MaxDifference max = new MaxDifference();
        List<Integer> px = new ArrayList<>(Arrays.asList(2, 3, 10, 6, 4, 8, 1));
        System.out.println(max.maxDifference(px));
    }
}
