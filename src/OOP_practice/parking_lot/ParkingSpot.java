package OOP_practice.parking_lot;

public class ParkingSpot {
    private String spotId;
    private Vehicle parkedVehicle;
    private SpotType type;

    private FittingSpotCheckStrategy fittingSpotCheck;

    public ParkingSpot(String spotId, Vehicle parkedVehicle, SpotType type, FittingSpotCheckStrategy fittingSpotCheck) {
        this.spotId = spotId;
        this.parkedVehicle = parkedVehicle;
        this.type = type;
        this.fittingSpotCheck = fittingSpotCheck;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean park(Vehicle vehicle) {
        if (!fittingSpotCheck.spotCanFitVehicle(this, vehicle)) {
            return false;
        }
        parkedVehicle = vehicle;
        return true;
    }

    public boolean remove() {
        if (parkedVehicle != null) {
            parkedVehicle = null;
            return true;
        }
        return false;
    }

    public String getSpotId() {
        return spotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public SpotType getType() {
        return type;
    }
}
