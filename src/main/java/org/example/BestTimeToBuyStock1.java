package org.example;

public class BestTimeToBuyStock1 {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = prices.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int max_profit = 0;
        while (left <= right) {
            if (prices[left] < min) {
                min = prices[left];
                left++;
            }
            if (prices[right] > max) {
                max = prices[right];
                right--;
            }
            else{
                left++;
                right--;
            }
            if(max>min){
            max_profit = Integer.max(max-min,max_profit);}
        }
        return max_profit;

    }
    public int maxProfit2(int[] prices) {
        int min[] = new int[prices.length];
        int max[] = new int[prices.length];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int maxProfit = 0;

        for(int i = 0 ; i< prices.length ;i++){
            if(prices[i]<minVal){
                minVal = prices[i];
            }
            min[i] = minVal;

        }
        printArray(min);
        for(int i = prices.length-1 ; i >=0; i--){
            if(prices[i]>maxVal){
                maxVal=prices[i];
            }
            max[i]=maxVal;
        }
        printArray(max);
        for(int i=0; i< min.length-1;i++){
            int diff = max[i+1]- min[i];
            maxProfit = Integer.max(maxProfit,diff);
        }
        return maxProfit;
    }

    public static void printArray(int arr[])
    {
        for(int i =0 ; i< arr.length ; i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
        public static void main(String args[]) {
        BestTimeToBuyStock1 bestTimeToBuyStock = new BestTimeToBuyStock1();
        int num[] = {7, 1, 5, 3, 6, 4};
        int num2[]={7,6,4,3,1};
        int num3[] = {2,1};
        int num4[]= {2,1,2,0,1};
        System.out.println(bestTimeToBuyStock.maxProfit2(num));

    }
}
