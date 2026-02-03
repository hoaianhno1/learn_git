package day3_notification_system;

public class EmailNotifier implements Notifier{
    private final String email;

    public EmailNotifier(String email) {
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Email is null or blank");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String send(String message) {
        return "Email to " +  this.getEmail() + "; Message: " + message;
    }
}
