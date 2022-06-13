package _9_objectorienteddesign.example4_1;

public class Car extends Vehicle {
    public static VehicleSize carSize = new VehicleSize(ParkingSpotType.Compact, 1);

    public Car() {
        super(carSize);
    }

    @Override
    public boolean isSuitable(ParkingSpotType spotType) {
        return spotType == ParkingSpotType.Large || spotType == ParkingSpotType.Compact;
    }

    public void print() {
        System.out.print("C");
    }
}
