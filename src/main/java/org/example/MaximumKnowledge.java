package org.example;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.*;

class Interval {
    public int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    boolean isPointInside(int p) {
        return p >= start && p <= end;
    }
}

class Meeting {
    public Interval t;
    public int knowledge;
    Meeting(Interval t, int knowledge) {
        this.t = t;
        this.knowledge = knowledge;
    }
}

public class MaximumKnowledge {

    public static long getMaxKnowledge(int d, List<Integer> s, List<Integer> e, List<Integer> a, int k) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        ArrayList<Integer> meetingDays = new ArrayList<>();
        for (int i = 0; i < e.size(); i++) {
            meetings.add(new Meeting(new Interval(s.get(i), e.get(i)), a.get(i)));
            meetingDays.add(s.get(i));
            meetingDays.add(e.get(i));
        }
        meetingDays.sort(null);
        long answer = 0;

        HashMap<Integer, ArrayList<Integer>> meetingsOnDay = new HashMap<>();
        for (int i = 0; i < meetingDays.size(); i++) {
            int day = meetingDays.get(i);
            meetingsOnDay.put(day, new ArrayList<>());
            ArrayList<Integer> knowledges = meetingsOnDay.get(day);
            for (int j = 0; j < meetings.size(); j++) {
                Meeting m = meetings.get(j);
                if (m.t.isPointInside(day)) {
                    knowledges.add(m.knowledge);
                }
            }
            Collections.sort(knowledges, Collections.reverseOrder());
            long sum = 0;
            for (int j = 0; j < k; j++) {
                if(j>=knowledges.size()){
                    break;
                }
                sum += knowledges.get(j);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main (String [] args){
        MaximumKnowledge maxKnow = new MaximumKnowledge();
        List<Integer> s = new ArrayList<>(Arrays.asList(2,5,4,3));
        List<Integer> e = new ArrayList<>(Arrays.asList(8,9,7,5));
        List<Integer> a = new ArrayList<>(Arrays.asList(800,1600,200,400));



        System.out.println(getMaxKnowledge(10,s,e,a,2 ));
    }
}
