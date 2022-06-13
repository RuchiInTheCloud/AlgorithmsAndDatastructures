package _9_objectorienteddesign.example4_1;

public class Bus extends Vehicle {
    public static VehicleSize busSize = new VehicleSize(ParkingSpotType.Large, 5);

    public Bus() {
        super(busSize);
    }

    @Override
    public boolean isSuitable(ParkingSpotType spotType) {
        return spotType == ParkingSpotType.Large;
    }

    public void print() {
        System.out.print("B");
    }
}
