package OOP_practice.parking_lot;

public class FittingSpotCheckDefault implements FittingSpotCheckStrategy {
    @Override
    public boolean spotCanFitVehicle(ParkingSpot spot, Vehicle vehicle) {
        if (!spot.isAvailable()) {
            return false;
        }
        switch (vehicle.getVehicleType()) {
            case MOTORCYCLE:
                return true;
            case CAR:
                return spot.getType().equals(SpotType.COMPACT) || spot.getType().equals(SpotType.LARGE);
            case TRUCK:
                return spot.getType().equals(SpotType.LARGE);
            default:
                return false;
        }
    }
}
