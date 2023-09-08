package org.example.StringsArrays;

public class Candy {

    public int candy(int[] ratings) {
        int candyCount = ratings.length;
        int candyArray[] = new int[ratings.length];

        for(int i = 0 ; i < ratings.length;i++) {
            if (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                candyArray[i] = Integer.max(candyArray[i+1]+1, candyArray[i]);
            }
            if(i - 1 >= 0 && ratings[i] > ratings[i-1]){
                candyArray[i] = Integer.max(candyArray[i-1]+1, candyArray[i]);
            }
        }
        for(int i = ratings.length-1 ; i >=0;i--) {
            if (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                candyArray[i] = Integer.max(candyArray[i+1]+1, candyArray[i]);
            }
            if(i - 1 >= 0 && ratings[i] > ratings[i-1]){
                candyArray[i] = Integer.max(candyArray[i-1]+1, candyArray[i]);
            }
            candyCount+=candyArray[i];
        }
        return candyCount;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int arr[] = {1,0,2};
        int arr2[] = {1,2,2};
        int arr3[] = {1,3,2,2,1};
        int arr4[] = {1,2,87,87,87,2,1};
        System.out.println(candy.candy(arr4));
    }
}
