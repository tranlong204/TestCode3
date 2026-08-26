package OOP_practice.payment_method;

public class PaypalPayment implements PaymentMethod {

    @Override
    public boolean process(double amount) {
        return true;
    }
}
