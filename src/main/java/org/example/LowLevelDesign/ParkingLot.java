package org.example.LowLevelDesign;

import java.time.LocalDateTime;


 class ParkingLot {
    public static void main(String[] args){
        Vehicle vehicle1 = new SmallVehicle("ABCD1234");
        Vehicle vehicle2 = new MediumVehicle("ABCD12343");
        ParkingLot parking = new ParkingLot();
        LocalDateTime now = LocalDateTime.now();
        Ticket ticket1 = new Ticket( now, vehicle1, vehicle1.getPrice( 3));
        Ticket ticket2 = new Ticket(now, vehicle1, vehicle2.getPrice( 5));
        System.out.println(ticket1.toString());
        System.out.println(ticket2.toString());

    }
}
enum Vehicles{
    small,
    medium,
    large
}

 interface Vehicle {

    public abstract String getVehicleNumber();

    public abstract int getPrice(int numberOfHours);


}
class SmallVehicle implements Vehicle {
    private String vehicleNumber;
    private Vehicles vehicle;

    public SmallVehicle( String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicle = Vehicles.small;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public int getPrice(int numberOfHours) {
        return 20 * numberOfHours;
    }
}
class MediumVehicle implements Vehicle {
    private String vehicleNumber;
    private Vehicles vehicle;

    public MediumVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicle = Vehicles.medium;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public int getPrice(int numberOfHours) {
        return 50 * numberOfHours;
    }
}

class LargeVehicle implements Vehicle {
    private final String vehicleNumber;
    private Vehicles vehicle;


    public LargeVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicle = Vehicles.large;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public int getPrice(int numberOfHours) {
        return 80 * numberOfHours;
    }
}
class Ticket{
    private String ticketNumber;
    private LocalDateTime date;
    private Vehicle vehicle;
    private int cost;
    Ticket(LocalDateTime date, Vehicle vehicle, int cost){
        this.date = date;
        this.vehicle = vehicle;
        this.cost = cost;
        this.ticketNumber = generateTicketNumberForVehicle(date);
    }

    private String generateTicketNumberForVehicle(LocalDateTime now){
        return this.vehicle.getVehicleNumber().toString()+now.toString();
    }
    public String getTicketNumber(){
        return this.ticketNumber;
    }
    public String toString(){
        return "Ticket Number : "+this.ticketNumber+" Date : "+date+" for vehicle "+vehicle.getVehicleNumber()+ " costs INR "+cost;
    }
}


