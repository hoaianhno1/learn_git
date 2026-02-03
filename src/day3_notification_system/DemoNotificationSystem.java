package day3_notification_system;

import java.util.ArrayList;
import java.util.List;

public class DemoNotificationSystem {
    public static void main(String[] args) {
        List<Notifier> notifiers = new ArrayList<>();
        notifiers.add(new EmailNotifier("a@gmail.com"));
        notifiers.add(new SmsNotifier("0900000000"));
        notifiers.add(new SlackNotifier("#general"));

        NotificationService service = new NotificationService();

        service.notifyAll(notifiers, "Hi");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.notifyAll(notifiers, "Hello");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.notifyAll(notifiers, "Bye");

        System.out.println("=== Logs before sort ===");
        service.printLogs(); //

        System.out.println("=== Logs after sort (timestamp desc) ===");
        service.printSortedLogs();
    }
}
