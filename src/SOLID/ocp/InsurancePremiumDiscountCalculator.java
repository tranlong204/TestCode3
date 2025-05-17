package SOLID.ocp;

public class InsurancePremiumDiscountCalculator {

    public static int calculatePremiumDiscountPercentage(CustomerProfile customer) {
        if (customer.isLoyalCustomer()) {
            return 20;
        }
        return 0;
    }

    public static void main(String[] args) {
        HealthCustomerProfile healthCustomerProfile = new HealthCustomerProfile();

        System.out.println(calculatePremiumDiscountPercentage(healthCustomerProfile));

        VehicleInsuranceCustomer vehicleInsuranceCustomer = new VehicleInsuranceCustomer();

        System.out.println(calculatePremiumDiscountPercentage(vehicleInsuranceCustomer));
    }
}
