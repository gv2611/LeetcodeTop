package org.example;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = Integer.MIN_VALUE;

        while(left <= right){
            maxWater = Integer.max(maxWater, (right-left)* Integer.min(height[left], height[right]));
            if(height[left] <= height[right]){
                left++;
            }
            else
            {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String [] args){
        ContainerWithMostWater container = new ContainerWithMostWater();
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(container.maxArea(height));
    }
}
