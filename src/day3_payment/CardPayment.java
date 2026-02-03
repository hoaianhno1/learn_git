package day3_payment;

public class CardPayment implements Payment {
    private String las4card;

    public CardPayment(String last4card){
        if(last4card == null || last4card.isBlank()){
            throw new IllegalArgumentException("Last4card is null");
        }

        this.las4card = last4card;
    }

    public String getLas4card() {
        return las4card;
    }

    @Override
    public String pay(long amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be > 0");
        }
        return "Paid: " + amount + "by card **** " + this.getLas4card();
    }
}