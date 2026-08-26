package OOP_practice.parking_lot;

public class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType, String licensePlate) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
