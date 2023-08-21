package org.example;

import java.util.ArrayList;

public class TrappingRainWater {

    public int trap(int[] height) {
        int len = height.length;
        ArrayList<Integer> highPoints = new ArrayList<>();
        int totalWaterTrapped = 0;

        for (int i = 0; i < height.length; i++) {
            if (i == 0 && i + 1 < height.length && height[i + 1] <= height[i]) {
                highPoints.add(i);
            }
            if (i == height.length - 1 && i - 1 >= 0 && height[i - 1] <= height[i]) {
                highPoints.add(i);
            }
            if (i - 1 >= 0 && i + 1 < height.length) {
                if (height[i - 1] < height[i] && height[i + 1] <= height[i]) {
                    highPoints.add(i);
                }
            }
        }
        System.out.println("High points before removal " + highPoints);

        for (int i = 1; i < highPoints.size() - 1; i++) {
            if (height[highPoints.get(i)] < height[highPoints.get(i - 1)] && height[highPoints.get(i)] < height[highPoints.get(i + 1)]) {
                highPoints.remove(i);
            }
        }
        System.out.println(highPoints);
        for (int i = 0; i < highPoints.size() - 1; i++) {
            System.out.println(highPoints.get(i) + "-" + highPoints.get(i + 1));
            int area = ((highPoints.get(i + 1) - highPoints.get(i) - 1) * Integer.min(height[highPoints.get(i)], height[highPoints.get(i + 1)]));
            int heightSubs=0;
            for(int j= highPoints.get(i)+1; j< highPoints.get(i+1) ; j++){
                int heightToSubstract = Integer.min(Integer.min(height[highPoints.get(i)], height[highPoints.get(i + 1)]), height[j]);
                heightSubs = heightSubs+heightToSubstract;
            }
            totalWaterTrapped = totalWaterTrapped + (area - heightSubs);
        }
        return totalWaterTrapped;
    }

    public int trap2(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int [height.length];
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int totalRainWater = 0;


        for(int i = 0 ; i < height.length ; i++){
            maxLeft = Integer.max(maxLeft, height[i]);
            left[i] = maxLeft;
        }

        for(int i = height.length-1 ; i>=0 ;i--){
            maxRight = Integer.max(maxRight, height[i]);
            right[i] = maxRight;
        }
        for(int i = 0 ; i< height.length;i++){
            totalRainWater += Integer.min(left[i], right[i]) - height[i];
        }
        return totalRainWater;
    }
        public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int height2[] = {4, 2, 0, 3, 2, 5};
        int height3[] = {5, 4, 1, 2};
        int height4[]={5,5,1,7,1,1,5,2,7,6};
        System.out.println(trw.trap2(height));
    }
}
