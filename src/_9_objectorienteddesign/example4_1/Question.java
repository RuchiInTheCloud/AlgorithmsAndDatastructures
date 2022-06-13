package _9_objectorienteddesign.example4_1;

import java.util.Random;

public class Question {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle vehicle = null;
        Random random = new Random();
        while (vehicle == null || lot.parkVehicle(vehicle)) {
            lot.print();
            int randomInt = random.nextInt(10);
            if (randomInt < 2) {
                vehicle = new Bus();
            } else if (randomInt < 4) {
                vehicle = new Motorcycle();
            } else {
                vehicle = new Car();
            }
            System.out.print("\nParking a ");
            vehicle.print();
            System.out.println();
        }
        lot.print();
    }
}
