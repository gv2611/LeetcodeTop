package org.example.Interviews.iggroups;

public class PlaneSeat {


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

        if(S.length()==0){
            return N*2;
        }
        // Implement your solution here
        String[] seats = S.split(" ");
        int[][] reservations = new int[N][10];
        for (int i = 0; i < seats.length; i++) {
            String str = seats[i];
            int seatNumber = (int) str.charAt(str.length() - 1) - 65;
            int j = 0;
            while (j < str.length()) {
                if (Character.isDigit(str.charAt(j))) {
                    j++;
                }
                else{
                    break;
                }
            }
            int row = Integer.parseInt(str.substring(0, j)) - 1;
            reservations[row][seatNumber] = 1;
        }
        int numFamilies = 0;
        for (int i = 0; i < N; i++) {
            if (firstAisle(reservations, i)==1 || secondAisle(reservations, i)==1) {
                numFamilies += firstAisle(reservations, i) + secondAisle(reservations, i);
            } else if (middle(reservations, i)==1) {
                numFamilies++;
            }
        }
        return numFamilies;
    }

    public static void main(String[] args) {
        PlaneSeat h = new PlaneSeat();
        System.out.println(h.solution(1, ""));
    }
}