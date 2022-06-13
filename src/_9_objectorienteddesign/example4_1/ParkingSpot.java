package _9_objectorienteddesign.example4_1;

public class ParkingSpot {
    private int row;
    private int spotNumber;
    private ParkingLevel level;
    private ParkingSpotType spotType;
    private Vehicle vehicle;

    public ParkingSpot(ParkingLevel level, int row, int spotNumber, ParkingSpotType spotType) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.spotType = spotType;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    /* Checks if the spot is big enough for the vehicle (and is available). This compares
     * the SIZE only. It does not check if it has enough spots. */
    public boolean isSuitable(Vehicle vehicle) {
        return isAvailable() && vehicle.isSuitable(this.spotType);
    }

    public int getRow() {
        return row;
    }

    public boolean park(Vehicle vehicle) {
        if (!isSuitable(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }
}
