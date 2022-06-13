package _9_objectorienteddesign.example4_1;

public class ParkingLot {
    ParkingLevel[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot() {
        levels = new ParkingLevel[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new ParkingLevel(i, 30);
        }
    }

    /* Park the vehicle in a spot (or multiple spots). Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level: levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}
