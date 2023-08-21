package org.example;

public class BestTimeToBuyStock2 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int max_profit=0;
        int min_pos=0;
        int max_pos=0;

        for(int i=0;i<prices.length-1;i++){
            if(prices[i] < min && prices[i]<prices[i+1] && min_pos<=max_pos){
                min = prices[i];
                min_pos = i;

            }
            if(prices[i] > max && prices[i]>prices[i+1] && max_pos>=min_pos){
                max = prices[i];
                max_pos = i;
            }
            if(min!=Integer.MAX_VALUE && max!=Integer.MIN_VALUE){
                max_profit=max_profit+(max-min);
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }
        return max_profit;
    }
    public int maxProfit2(int[] prices) {
        int min[] = new int[prices.length];
        int max[] = new int[prices.length];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int maxProfit = 0;

        int len= prices.length;
        min[0] = prices[0];

        for(int i = 1 ; i< len ;i++){
                if(prices[i]<prices[i-1]){
                minVal = prices[i];}
                else{
                    minVal=min[i-1];
                }

            min[i] = minVal;

        }
        printArray(min);
        max[len-1] = prices[len-1];
        for(int i = prices.length-2 ; i >=0; i--){
                if(prices[i] > prices[i+1]){
                maxVal=prices[i];}
                else{
                    maxVal=max[i+1];
                }
            max[i]=maxVal;
        }
        int distinct_min = -1;
        int distinct_max=-1;
        printArray(max);
        for(int i=0;i<len-1;i++) {
            if(max[i+1] > min[i] &&( max[i+1]!=distinct_max && min[i]!=distinct_min)){
                distinct_max = max[i+1];
                distinct_min = min[i];
                maxProfit = maxProfit + (max[i+1]-min[i]);
            }
        }
        return maxProfit;
    }
    public int maxProfit3(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] - minPrice > 0) {
                profit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return profit;
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
        BestTimeToBuyStock2 bestTimeToBuyStock = new BestTimeToBuyStock2();
        int num[] = {7, 1, 5, 3, 6, 4};
        int num2[]={7,6,4,3,1};
        int num3[] = {2,1,4};
        int num4[]= {2,1,2,0,1};
        int num5[] = {1,2,3,4,5};
        System.out.println(bestTimeToBuyStock.maxProfit3(num3));
    }
}

