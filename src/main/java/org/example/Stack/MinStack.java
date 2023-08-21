package org.example.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinStack {
    List<Integer> list ;
    public MinStack() {
        list = new ArrayList<>();

    }

    public void push(int val) {
        this.list.add(val);
    }

    public void pop() {
        this.list.remove(this.list.size()-1);
    }

    public int top() {
        return this.list.get(this.list.size()-1);


    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i< this.list.size();i++ ){
            min = Integer.min(min, this.list.get(i));
        }
        return min;
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
       System.out.println( minStack.top());
        System.out.println(minStack.getMin());
    }
}
