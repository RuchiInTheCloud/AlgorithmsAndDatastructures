package _9_objectorienteddesign.example4_1;

public class Motorcycle extends Vehicle {
    public static VehicleSize motorCycleSize = new VehicleSize(ParkingSpotType.Motorcycle, 1);

    public Motorcycle() {
        super(motorCycleSize);
    }

    @Override
    public boolean isSuitable(ParkingSpotType spotType) {
        return true;
    }
}
