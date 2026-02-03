package day3_payment;

public class PaymentProcessor {

    public PaymentProcessor(){}
    public void process(Payment payment, long amount){
        if(payment == null){
            throw new IllegalArgumentException("Payment method is null");
        }
        System.out.println(payment.pay(amount));
    }
}
