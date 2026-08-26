package OOP_practice.payment_method;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean process(double amount) {
        return true;
    }
}
