package OOP_practice.parking_lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String id;
    private List<ParkingFloor> floors;

    public ParkingLot(String id, List<ParkingFloor> floors) {
        this.id = id;
        this.floors = floors;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor: floors) {
            if (floor.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingFloor floor: floors) {
            if (floor.removeVehicle(vehicle.getLicensePlate())) {
                return true;
            }
        }
        return false;
    }
}
