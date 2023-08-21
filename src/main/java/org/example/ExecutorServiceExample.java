package org.example;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void printNumbers(ArrayList<Integer> al) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Future<Void>> futures = new ArrayList<>();
// 1-30000  0 - 300 300-600 600-900 900-1200
        int numsPerTask = 50;
        for(int i =0 ; i +numsPerTask < al.size(); i += numsPerTask){
            int j = i;
            Callable<Void> callableTask = () -> printNumbers2(al, j, j + numsPerTask);
            futures.add(executorService.submit(callableTask));
        }
        for (Future<Void> f : futures) {
            f.get();
        }
    }

    private static Void printNumbers2(ArrayList<Integer> al, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println(al.get(i));
        }
        return null;
    }

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorServiceExample exc = new ExecutorServiceExample();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i =0 ; i< 30000;i++){
            al.add(i);
        }
        exc.printNumbers(al);
    }


}
