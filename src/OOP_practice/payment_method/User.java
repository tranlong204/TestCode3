package OOP_practice.payment_method;

public class User {

    public static void main(String[] args) {
        PaymentMethod paypalPayment = new PaypalPayment();
        OrderService orderService = new OrderService(paypalPayment);
//        orderService.
    }
}
