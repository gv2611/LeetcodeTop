package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class RandomizedSet {
   private static ArrayList<Integer> al;


    public RandomizedSet() {
        al = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!al.contains(val)) {
            al.add(val);
            return true;

        }
   //     System.out.println(al);
        return false;

    }

    public boolean remove(int val) {
        Integer val1 = new Integer(val);

        if (!al.contains(val1)) {
            return false;
        } else {
            al.remove(val1);
            return true;
        }
    }

    public int getRandom() {
        int len = al.size()-1;
        int min = 0;
        int max = len;

        Random random = new Random();
        int randomNumber = random.nextInt(max-min+1)+min;
     //   System.out.println(al);

        return al.get(randomNumber);

    }

    public static void main(String [] args){
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */