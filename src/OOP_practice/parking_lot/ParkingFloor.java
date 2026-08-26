package OOP_practice.parking_lot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> spots;
    private Map<String, ParkingSpot> occupiedSpotByVehicleMap;

    public ParkingFloor(String floorId, List<ParkingSpot> spots, Map<String, ParkingSpot> occupiedSpotByVehicleMap) {
        this.floorId = floorId;
        this.spots = spots;
        this.occupiedSpotByVehicleMap = new HashMap<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
//        for (ParkingSpot spot : spots) {
//            if (spot.canFitVehicle(vehicle)) {
//                spot.park(vehicle);
//                occupiedSpotByVehicleMap.put(vehicle.getLicensePlate(), spot);
//                return true;
//            }
//        }
        return false;
    }

    public boolean removeVehicle(String licensePlate) {
        ParkingSpot spot = occupiedSpotByVehicleMap.get(licensePlate);
        if (spot != null) {
            spot.remove();
            return true;
        }
        return false;
    }
}
