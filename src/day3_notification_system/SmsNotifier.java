package day3_notification_system;

public class SmsNotifier implements Notifier{
    private final String phone;

    public SmsNotifier(String phone) {
        if(phone == null || phone.isBlank()){
            throw new IllegalArgumentException("Phone is null or blank");
        }
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String send(String message) {
        return "SMS to " + this.getPhone() + "; Message: " + message;
    }
}
