package org.example.SlidingWindow;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left;
        int right;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        if (nums.length == 1 && nums[0] >= target) {
            return 1;
        }
        if (nums.length > 1) {
            left = 0;
            right = 1;
            sum = sum + nums[left] + nums[right];

            while (left != right && left < nums.length && right < nums.length) {
                if(nums[left] >= target){
                    return 1;
                }
                if(nums[right] >= target){
                    return 1;
                }
                if (sum < target) {
                    right++;
                    if (right < nums.length)
                        sum = sum + nums[right];
                }
                if (sum > target) {
                    int len = right - left + 1;
                    minLen = Integer.min(minLen, len);
                    sum = sum - nums[left];
                    if (left < nums.length)
                        left++;
                }
                if (sum == target) {
                    int len = right - left + 1;
                    minLen = Integer.min(minLen, len);
                    if (left < nums.length && right< nums.length)
                    {
                        sum = sum - nums[left];
                        left++;
                    }

                }
            }
        }
        if (sum < target && minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minsum = new MinimumSizeSubarraySum();
        int[] num = {2, 3, 1, 2, 4, 3};
        int[] num2 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] num3 = {7};
        int[] nums4 = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        int[]num5 = {10,2,3};
        int target2 = 11;
        int target = 7;
        System.out.println(minsum.minSubArrayLen(6, num5));
    }


}
