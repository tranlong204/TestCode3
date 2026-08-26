package OOP_practice.payment_method;

public class OrderService {
    PaymentMethod paymentMethod;

    public OrderService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(Order order) {
        paymentMethod.process(order.total);
    }
}
