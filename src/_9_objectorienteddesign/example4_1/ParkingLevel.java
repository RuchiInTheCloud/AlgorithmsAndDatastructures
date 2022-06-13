package _9_objectorienteddesign.example4_1;

public class ParkingLevel {
    private static final int SPOTS_PER_ROW = 10;

    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots;

    public ParkingLevel(int floor, int numberSpots) {
        this.floor = floor;
        spots = new ParkingSpot[numberSpots];
        int largeSpots = numberSpots / 4;
        int bikeSpots = numberSpots / 4;
        int compactSpots = numberSpots - largeSpots - bikeSpots;
        for (int i = 0; i < numberSpots; i++) {
            ParkingSpotType parkingSpotType = ParkingSpotType.Motorcycle;
            if (i < largeSpots) {
                parkingSpotType = ParkingSpotType.Large;
            } else if (i < largeSpots + compactSpots) {
                parkingSpotType = ParkingSpotType.Compact;
            }
            int row = i / SPOTS_PER_ROW;
            spots[i] = new ParkingSpot(this, row, i, parkingSpotType);
        }
        availableSpots = numberSpots;
    }

    public int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    public void spotFreed() {
        availableSpots += 1;
    }

    public void print() {
        int lastRow = -1;
        for (ParkingSpot spot: spots) {
            if (spot.getRow() != lastRow) {
                System.out.print("  ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int spotsFound = 0;
        int lastRow = -1;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];

            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }

            if (spot.isSuitable(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }

            if (spotsFound == spotsNeeded) {
                return i - spotsFound + 1;
            }
        }
        return -1;
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        boolean success = true;
        for (int i = spotNumber; i < spotNumber + vehicle.getSpotsNeeded(); i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.getSpotsNeeded();
        return success;
    }
}
