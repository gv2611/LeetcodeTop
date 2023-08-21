package org.example;


import java.util.Arrays;
        import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.List;

public class RingCentral2 {

    public static void main(String[] args) {
        System.out.println(filterList(new LinkedList<>(Arrays.asList(1L, 2L, 3L, 4L))));
        // Answer: 2L 3L 4L
    }

    private static List<Long> filterList(List<Long> longList) {
        for (Iterator<Long> iterator = longList.iterator(); iterator.hasNext(); ) {
            Long obj = iterator.next();
            if (obj < 2L)
                longList.remove(obj);
        }
        return longList;
    }
}
