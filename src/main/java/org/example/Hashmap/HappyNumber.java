package org.example.Hashmap;

public class HappyNumber {

    public boolean isHappy(int n) {
        int a, square, sum = 0;
        int z = n;
        while (n != 0) {
            a = n % 10;
            square = a * a;
            sum = sum + square;
            n = n / 10;
        }


            if (sum == 1) {
                return true;
            } else if (sum == z || sum == 4) {
                return false;
            } else {
                return isHappy(sum);
            }
        }


    public static void main(String[] args) {
        HappyNumber happy = new HappyNumber();
        System.out.println(happy.isHappy(1111111));
    }
}
