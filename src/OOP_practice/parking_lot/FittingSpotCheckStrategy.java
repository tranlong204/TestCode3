package OOP_practice.parking_lot;

public interface FittingSpotCheckStrategy {
    boolean spotCanFitVehicle(ParkingSpot spot, Vehicle vehicle);
}
