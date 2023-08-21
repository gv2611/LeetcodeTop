package org.example;// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//
//You are processing plane seat reservations. The plane has N rows of seats, numbered from 1
//        to N. There are ten seats in each row (labelled from A to K, with letter | omitted), as shown in
//        the figure below:
//
//        Some of the seats are already reserved. The list of reserved seats is given as a string S (of
//        length M) containing seat numbers separated by single spaces: for example, "1A 3C 2B 206
//        5A". The reserved seats can be listed in S in any order.
//
//        Your task is to allocate seats for as many four-person families as possible. A four-person
//        family occupies four seats in one row, that are next to each other - seats across an aisle (such
//        as 2C and 2D) are not considered to be next to each other. It is permissible for the family to be
//        separated by an aisle, but in this case exactly two people have to sit on each side of the aisle.
//        Obviously, no seat can be allocated to more than one family.
//
//        Write a function:
//class Solution { public int solution(int N, String S); }
//
//that, given the number of rows N and a list of reserved seats as string S, returns the maximum
//        number of four-person families that can be seated in the remaining unreserved seats.
//
//        Examples:
//
//        1.Given N=2andS="1A 2F 1C",your function should return 2. The following figure shows
//        one possible way of seating two families in the remaining seats:
//Examples:
//
//        1.Given N=2andS = "1A 2F 1C",your function should return 2. The following figure shows
//        one possible way of seating two families in the remaining seats:
//
//        2.Given N'=1and'S = "" (empty string), your function should return 2, because we can seat at
//        most two families in a single row of seats, as shown in the figure below:
//
//        3.GivenN=22andS="1A 3C 2B 20G 5A", the function should return 41.
//        Assume that:
//
//        « Nis an integer within the range [1..50];
//
//        « Mis an integer within the range [0..1,909];
//
//        « string S consists of valid seat names separated with single spaces;
//        «every seat number appears in string S at most once.
class RakutenPlane {

    public int firstAisle(int[][] reservations, int r) {
        for (int j = 1; j <= 4; j++) {
            if (reservations[r][j] == 1) {
                return 0;
            }
        }
        return 1;
    }

    public int middle(int[][] reservations, int r) {
        for (int j = 3; j <= 6; j++) {
            if (reservations[r][j] == 1) {
                return 0;
            }
        }
        return 1;
    }

    public int secondAisle(int[][] reservations, int r) {
        for (int j = 5; j <= 8; j++) {
            if (reservations[r][j] == 1) {
                return 0;
            }
        }
        return 1;
    }

    public int solution(int N, String S) {
        // Implement your solution here
        String[] seats = S.split(" ");
        if(S.length() == 0){
            seats = new String[]{};
        }
        int[][] reservations = new int[N][10];
        for (int i = 0; i < seats.length; i++) {
            String str = seats[i];
            int seatNumber = (int)str.charAt(str.length() - 1) - 65;
            int j = 0;
            while (j < str.length()) {
                if (!Character.isDigit(str.charAt(j))) {
                    break;
                }
                j++;

            }
            int row = Integer.parseInt(str.substring(0, j)) - 1;
            reservations[row][seatNumber] = 1;
        }
        int numFamilies = 0;
        for (int i = 0; i < N; i++) {
            if (firstAisle(reservations, i) == 1 || secondAisle(reservations, i) == 1) {
                numFamilies += firstAisle(reservations, i) + secondAisle(reservations, i);
            } else if (middle(reservations, i) == 1) {
                numFamilies++;
            }
        }
        return numFamilies;
    }

    public static void main(String[] args) {
        RakutenPlane h = new RakutenPlane();
//        System.out.println(h.solution(2, "1A 2F 1C"));
//        System.out.println(h.solution(22, "1A 3C 2B 20G 5A"));
        System.out.println(h.solution(1, ""));


    }
}