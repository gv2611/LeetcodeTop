package org.example.Interviews.vmware;

import java.util.*;

public class VMWare {

    public int maxDistance(List<Integer> pos, int m) {
        Collections.sort(pos);
        int n = pos.size();
        int res = -1;

        int left = 1, right = pos.get(n-1);
        while (left < right) {
            int mid = (left + right) / 2;

            if (canBePlaced(mid, pos, n, m)) {
                res = Math.max(res, mid);
                left = mid + 1;
            }
            else
                right = mid;
        }
        return res;
    }

    public static boolean canBePlaced(int mid, List<Integer> positions, int n,
                              int m)
    {
        int pos = positions.get(0);
        int elements = 1;

        for (int i = 1; i < n; i++) {
            if (positions.get(i) - pos >= mid) {
                pos = positions.get(i);
                elements++;

                if (elements == m)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        VMWare vmware = new VMWare();
        List<Integer> pos = new ArrayList<>(Arrays.asList(5,4,3,2,1,10000));

        int m = 2;
        System.out.println(vmware.maxDistance(pos, m));

    }
}
