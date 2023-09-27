package org.example.ClearTrip;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

enum WorkoutType{
    Weights,
    Cardio,
    Yoga,
    Swimming
}
class Centers{
    private String centerName;
    private ArrayList<ArrayList<Integer>> timings;
    private WorkoutType workoutType;
    private int availableSlots;


    ArrayList<String> allCenter = new ArrayList<>();
    HashMap<String, ArrayList<ArrayList<Integer>>> timingMap = new HashMap<>();
    HashMap<String, ArrayList<WorkoutType>> workoutTypeMap = new HashMap<>();

    HashMap<String, HashMap<WorkoutType, ArrayList<Integer>>> slotsMapping = new HashMap<>();

    HashMap<WorkoutType, ArrayList<String>> typeAtCenters = new HashMap<>();


    Centers(String name){
        allCenter.add(name);
        timingMap.put(name, new ArrayList<ArrayList<Integer>>());
        workoutTypeMap.put(name, new ArrayList<WorkoutType>());


    }
    Centers(String centerName, ArrayList<ArrayList<Integer>> timings, WorkoutType workoutType ){
        this.centerName = centerName;
        this.timings = timings;
        this.workoutType = workoutType;
        this.availableSlots = 0;
    }

    public void addCenter(String centerName){
        allCenter.add(centerName);
    }

    public void printCenterDetails(){
        System.out.println("All Slots for this center: "+ this.timingMap.get(this.centerName));



    }

    public void addCenterActivities ( String centerName, ArrayList<WorkoutType> activities){
        if(!workoutTypeMap.containsKey(centerName)){
            workoutTypeMap.put(centerName, activities );
        }

        for(int i = 0; i<activities.size();i++){
            if(typeAtCenters.containsKey(activities.get(i))){
                typeAtCenters.get(activities.get(i)).add(centerName);
            }
            else{
                typeAtCenters.put(activities.get(i), new ArrayList<>(Arrays.asList(centerName)));
            }
        }
    }
    public void addCenterTimings ( String centerName, ArrayList<ArrayList<Integer>> timings){
        ArrayList<ArrayList<Integer>> timingsForCenter = new ArrayList<>();
        if(!timingMap.containsKey(centerName)){
            for(int i = 0; i<timings.size();i++){
                timingsForCenter.add((ArrayList<Integer>) Arrays.asList(timings.get(i).get(0), timings.get(i).get(1)));
            }
            timingMap.put(centerName, timingsForCenter);
        }
        else{
            ArrayList<ArrayList<Integer>> timingList = new ArrayList<>();
            timingList = timingMap.get(centerName);
        }
    }
    public void addWorkout (String centerName,  WorkoutType workoutType, List<Integer> timing, int slot ){
        ArrayList<ArrayList<Integer>> timingsForCenter = getTimingsForCenter(centerName);

        for(int i=0; i<timingsForCenter.size(); i++){
            if(timing.get(0) >= timingsForCenter.get(i).get(0) && timing.get(1) <= timingsForCenter.get(i).get(1)){
                HashMap<WorkoutType, ArrayList<Integer>> typeToTiming = null;
                typeToTiming.put(workoutType, new ArrayList<>(Arrays.asList(timing.get(0), timing.get(1), slot)));
                slotsMapping.put(centerName, typeToTiming);
            }
        }
    }



    private ArrayList<ArrayList<Integer>> getTimingsForCenter(String centerName) {
        return timingMap.get(centerName);
    }

    public String toString(){
        return this.centerName+" "+ this.workoutType;
    }

}

//class Admin{
//    Centers center = new Centers();
//    Admin(){
//
//    }
//
//}

class User{

    private String name;

    User(String name){
        this.name= name;
    }

    public void viewWorkoutAvailability(WorkoutType type){

    }
}
public class ClearFit {

    public static void main(String[] args){

        Centers center = new Centers("Koramangala");
      //  center.addCenter("Koramangala");
        ArrayList<Centers> allCenters = new ArrayList<>();
        ArrayList<ArrayList<Integer>> timings = new ArrayList<>();
        ArrayList<Integer> eachTime = new ArrayList<>(Arrays.asList(8, 20));
        timings.add(eachTime);
        center.addCenterTimings("Koramangala", timings);
        ArrayList<WorkoutType> activities = new ArrayList<>(Arrays.asList(WorkoutType.Yoga, WorkoutType.Cardio));
        center.addCenterActivities("Koramangala", activities );
        System.out.println("Center Details : ");
        center.printCenterDetails();
        allCenters.add(center);
        System.out.println(allCenters);


    }
}
