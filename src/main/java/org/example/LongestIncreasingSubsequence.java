//import java.util.ArrayList;
//
//public class LongestIncreasingSubsequence {
//
//    public int[] longestIncreasingSubsequence(int [] arr, int n){
//
//        ArrayList<Integer> output = new ArrayList<>();
//
//        if(n == 1){
//            return arr;
//        }
//        for(int i= 1; i< n; i++){
//            longestIncreasingSubsequence(arr, i );
//            if(arr[i] < arr[i+1]){
//                output.add(arr[i])
//            }
//
//        }
//
//
//    }
//
//    public static void printArray(int arr[]){
//
//        for(int i = 0 ; i<arr.length;i++){
//            System.out.println(arr[i]+" ");
//        }
//    }
//
//
////Input: arr[] = {3, 10, 2, 1, 20}
////        Output: 3
////        Explanation: The longest increasing subsequence is 3, 10, 20
//
//    public static void main(String [] args){
//        int arr[] = {3, 10, 2, 1, 20};
//        int len = arr.length;
//        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
//        lis.longestIncreasingSubsequence(arr, len);
//        printArray(arr);
//
//    }
//}
