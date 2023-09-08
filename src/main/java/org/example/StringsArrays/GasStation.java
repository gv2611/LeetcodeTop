package org.example.StringsArrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total=0,avail=0,index=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            avail+=gas[i]-cost[i];
            if(avail<0){
                avail=0;
                index=i+1;
            }
        }
        if(total<0){
            return -1;
        }
        return index;

    }
    private static void printArray(int[] arr) {
        for(int i = 0 ;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String [] args){
        GasStation gasStation = new GasStation();
        int gas [] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};

        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }
}
