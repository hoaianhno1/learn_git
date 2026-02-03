package day3_payment;

public class BankTransferPayment implements Payment {
    private String bankName;

    public BankTransferPayment(String bankName){
        if(bankName == null || bankName.isBlank()){
            throw new IllegalArgumentException("Bank name is null or blank");
        }
        this.bankName = bankName;
    }
    @Override
    public String pay(long amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be > 0");
        }
        return "Paid: " + amount + "via transfer to " + bankName;
    }
}
