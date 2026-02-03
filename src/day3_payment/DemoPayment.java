package day3_payment;

public class DemoPayment {
    static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        Payment cardPayment = new CardPayment("6666");
        Payment bankPayment = new BankTransferPayment("Vietcombank");

        processor.process(cardPayment, 1000);
        processor.process(bankPayment, 1234);

        try{
            processor.process(cardPayment, -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
