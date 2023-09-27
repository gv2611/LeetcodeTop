package org.example.CultFit;

import org.example.StringsArrays.LengthOfLastWord;

//import java.time.LocalDateTime;
import java.util.*;

import static org.example.CultFit.Admin.getSlotDetails;

public class CultFit {

    public static void main(String[] args) {
        Center koramangala = new Center();
        Center bannerghatta = new Center();

        final String koramangalaCenter = "Koramangala";
        final String banneghattaCenter = "Bannerghatta";
        koramangala.addCenter(koramangalaCenter);
        List<Timings> timingsKoramangala = new ArrayList<>(Arrays.asList(new Timings(12, 17), new Timings(18, 19)));
        List<Timings> timingsBannerghatta = new ArrayList<>(Arrays.asList(new Timings(10, 12), new Timings(13, 19)));

        koramangala.addCenterTimings(koramangalaCenter, timingsKoramangala);
        bannerghatta.addCenterTimings(banneghattaCenter, timingsBannerghatta);

        List<WorkoutType> activitiesKoramangala = new ArrayList<>(Arrays.asList(WorkoutType.Yoga, WorkoutType.Weights));
        List<WorkoutType> activitiesBannerghatta = new ArrayList<>(Arrays.asList(WorkoutType.Cardio, WorkoutType.Weights));

        koramangala.addCenterActivities(koramangalaCenter, activitiesKoramangala);
        bannerghatta.addCenterActivities(banneghattaCenter, activitiesBannerghatta);

        System.out.println(koramangala.getCenterTiming());
        System.out.println(koramangala.getCenterWorkouts());
        System.out.println(bannerghatta.getCenterTiming());
        System.out.println(bannerghatta.getCenterWorkouts());

        Admin admin1 = new Admin();
        admin1.addWorkout(koramangalaCenter, WorkoutType.Weights, 12, 13, 100);
        admin1.addWorkout(banneghattaCenter, WorkoutType.Cardio, 1, 5, 120);

        System.out.println(admin1.getSlotDetails());
        User user1 = new User();
        System.out.println(user1.viewWorkoutAvailability(WorkoutType.Weights));
        user1.viewWorkoutAvailability(WorkoutType.Cardio);
        user1.bookASession("Vaibhav", "Koramangala", WorkoutType.Weights, 12, 13);
        user1.bookASession("Vaibhav12", "Koramangala", WorkoutType.Weights, 12, 13);
        System.out.println(user1.viewWorkoutAvailability(WorkoutType.Weights));

        user1.cancelSession("Vaibhav12", "Koramangala", WorkoutType.Weights, 12, 13);


        System.out.println(user1.viewWorkoutAvailability(WorkoutType.Weights));
    }
}

enum WorkoutType {
    Weights,
    Cardio,
    Swimming,
    Yoga
}


class Center {
    String name;
    int startTime;
    int endTime;
    static HashMap<String, List<Timings>> centerTimings = new HashMap<>();
    static HashMap<String, List<WorkoutType>> centerWorkouts = new HashMap<>();

    public void addCenter(String name) {
        centerTimings.put(name, new ArrayList<>());
    }

    public void addCenterTimings(String name, List<Timings> timings) {
        if (centerTimings.containsKey(name)) {
            for (int i = 0; i < timings.size(); i++) {
                centerTimings.get(name).add(timings.get(i));
            }
        } else {
            for (int i = 0; i < timings.size(); i++) {
                centerTimings.put(name, timings);
            }
        }
    }

    public void addCenterActivities(String name, List<WorkoutType> activities) {
        if (centerWorkouts.containsKey(name)) {
            for (int i = 0; i < activities.size(); i++) {
                centerWorkouts.get(name).add(activities.get(i));
            }
        } else {
            for (int i = 0; i < activities.size(); i++) {
                centerWorkouts.put(name, activities);
            }
        }
    }

    public static HashMap<String, List<Timings>> getCenterTiming() {
        return centerTimings;
    }

    public static HashMap<String, List<WorkoutType>> getCenterWorkouts() {
        return centerWorkouts;
    }

    public String toString() {
        return "The center " + this.name + " is open from " + this.startTime + " to " + this.endTime;
    }
}

class Timings {
    int startTime;
    int endTime;

    public Timings(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Timings{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

class Slots {
    int startTime;
    int endTime;
    int availableSlots;

    Slots(int startTime, int endTime, int availableSlots) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableSlots = availableSlots;
    }

    @Override
    public String toString() {
        return "Slots{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", availableSlots=" + availableSlots +
                '}';
    }
}

class WeightDetails {
    String centerName;
    WorkoutType workoutType;
    int start;
    int end;
    int availableSlots;

    public WeightDetails(String centerName, WorkoutType workoutType, int start, int end, int availableSlots) {
        this.centerName = centerName;
        this.workoutType = workoutType;
        this.start = start;
        this.end = end;
        this.availableSlots = availableSlots;
    }

    @Override
    public String toString() {
        return "WeightDetails{" +
                "centerName='" + centerName + '\'' +
                ", workoutType=" + workoutType +
                ", start=" + start +
                ", end=" + end +
                ", availableSlots=" + availableSlots +
                '}';
    }
}

class Admin {
    static HashMap<String, HashMap<WorkoutType, Slots>> slotDetails = new HashMap<>();
    public void addWorkout(String centerName, WorkoutType type, int start, int end, int avaiableSlots) {

        Slots thisSlot = new Slots(start, end, avaiableSlots);
        HashMap<String, List<Timings>> centerTimings = Center.getCenterTiming();

        for (int i = 0; i < centerTimings.size(); i++) {
            if (centerTimings.get(centerName).get(i).startTime <= start || centerTimings.get(centerName).get(i).endTime >= end) {
                if (slotDetails.containsKey(centerName)) {
                    if (!slotDetails.get(centerName).containsKey(type)) {
                        slotDetails.get(centerName).put(type, thisSlot);
                    }
                } else {
                    HashMap<WorkoutType, Slots> hm = new HashMap<>();
                    hm.put(type, thisSlot);
                    slotDetails.put(centerName, hm);
                }
            }
        }
    }

    public static HashMap<String, HashMap<WorkoutType, Slots>> getSlotDetails() {
        return slotDetails;
    }
}

class Booking {
    String userId;
    String center;
    WorkoutType type;
    int start;
    int end;

    public Booking(String userId, String center, WorkoutType type, int start, int end) {
        this.userId = userId;
        this.center = center;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", center='" + center + '\'' +
                ", type=" + type +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

class User {

    static HashMap<String, HashMap<WorkoutType, Slots>> bookedSessions = new HashMap<>();
    static HashMap<String, String> userId = new HashMap<>();
    static List<Booking> allBookings = new ArrayList<>();

    public String register(String name) {
        String id = null;
        if (!userId.containsKey(name)) {
            id = name;
            userId.put(id, name);
        } else {
            id = generateUniqueUserId(name);
            userId.put(id, name);
        }
        System.out.println("User registered with id " + id);
        return id;
    }

    private String generateUniqueUserId(String name) {
        int append = 1;
        String id = null;
        while (userId.containsKey(name)) {
            id = name + String.valueOf(append);
        }
        return id;
    }


    public ArrayList<WeightDetails> viewWorkoutAvailability(WorkoutType type) {

        ArrayList<WeightDetails> weightDetails = new ArrayList<>();
        HashMap<String, HashMap<WorkoutType, Slots>> slotDetails = getSlotDetails();

        for (Map.Entry<String, HashMap<WorkoutType, Slots>> eachSlot : slotDetails.entrySet()) {

            HashMap<WorkoutType, Slots> innerMap = eachSlot.getValue();

            for (Map.Entry<WorkoutType, Slots> innerEntry : innerMap.entrySet()) {
                WorkoutType workoutType = innerEntry.getKey();
                if (workoutType.equals(type)) {
                    WeightDetails wt = new WeightDetails(eachSlot.getKey(), innerEntry.getKey(), innerEntry.getValue().startTime, innerEntry.getValue().endTime, innerEntry.getValue().availableSlots);
                    weightDetails.add(wt);

                }
            }
        }
        return weightDetails;
    }


    public void bookASession(String id, String center, WorkoutType type, int start, int end) {
        HashMap<String, HashMap<WorkoutType, Slots>> slotDetails = getSlotDetails();
        String generatedId = null;
        Booking thisBooking = null;

        for (Map.Entry<String, HashMap<WorkoutType, Slots>> eachSlot : slotDetails.entrySet()) {
            String thisCenter = eachSlot.getKey();
            if (thisCenter.equals(center)) {
                HashMap<WorkoutType, Slots> innerMap = eachSlot.getValue();
                for (Map.Entry<WorkoutType, Slots> innerEntry : innerMap.entrySet()) {
                    WorkoutType workoutType = innerEntry.getKey();
                    if (workoutType.equals(type) && innerEntry.getValue().startTime <= start && innerEntry.getValue().endTime >= end) {

                        if (userId.containsKey(id)) {
                            generatedId = id;
                        } else {
                            generatedId = register(id);
                        }
                        //  userId.put(generatedId, id);
                        thisBooking = new Booking(generatedId, center, type, start, end);
                        allBookings.add(thisBooking);
                        innerEntry.getValue().availableSlots--;
                    }
                }
            }
        }
        if (thisBooking == null) {
            System.out.println("This slot is not available at this center, please try to book a different slots");
        }
        System.out.println("Details of the session booked" + thisBooking);
    }

    public void cancelSession(String id, String center, WorkoutType type, int start, int end) {
        for (int i = 0; i < allBookings.size(); i++) {
            if (allBookings.get(i).userId.equals(id)) {
                allBookings.remove(i);
            }
        }
        HashMap<String, HashMap<WorkoutType, Slots>> slotDetails = getSlotDetails();


        for (Map.Entry<String, HashMap<WorkoutType, Slots>> eachSlot : slotDetails.entrySet()) {
            String thisCenter = eachSlot.getKey();
            if (thisCenter.equals(center)) {
                HashMap<WorkoutType, Slots> innerMap = eachSlot.getValue();
                for (Map.Entry<WorkoutType, Slots> innerEntry : innerMap.entrySet()) {
                    WorkoutType workoutType = innerEntry.getKey();
                    if (workoutType.equals(type) && innerEntry.getValue().startTime <= start && innerEntry.getValue().endTime >= end) {
                        innerEntry.getValue().availableSlots++;
                    }
                }
            }
        }
    }
}

