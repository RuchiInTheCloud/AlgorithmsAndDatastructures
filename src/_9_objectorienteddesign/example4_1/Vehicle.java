package _9_objectorienteddesign.example4_1;

import _3_arraysandstrings.datastructures.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots;
    protected VehicleSize vehicleSize;

    protected Vehicle(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
        parkingSpots = new ArrayList<>(vehicleSize.spotsNeeded);
    }

    public abstract boolean isSuitable(ParkingSpotType spotType);
    public abstract void print();

    public int getSpotsNeeded() {
        return vehicleSize.spotsNeeded;
    }

    public void parkInSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void unpark() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }
}
