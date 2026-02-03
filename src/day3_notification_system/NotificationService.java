package day3_notification_system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NotificationService {
    private final List<NotificationLog> logs = new ArrayList<>();

    public void notifyAll(List<Notifier> notifiers, String message){
        for(Notifier n : notifiers){
            System.out.println(n.send(message));
            String channelType = n.getClass().getSimpleName();
            NotificationLog log = new NotificationLog(channelType, message, LocalDateTime.now());
            logs.add(log);
        }
    }

    public void printLogs() {
        for (NotificationLog log : logs) {
            System.out.println(log);
        }
    }
    public void printSortedLogs(){
        List<NotificationLog> sortedLogs = new ArrayList<>(logs);
        //AnonymousClass
//        Collections.sort(sortedLogs, new Comparator<NotificationLog>() {
//            @Override
//            public int compare(NotificationLog o1, NotificationLog o2) {
//                return o2.getTimeStamp().compareTo(o1.getTimeStamp());
//            }
//        });

        //Lambra
        sortedLogs.sort((o1, o2) -> {
                int timeCmp = o2.getTimeStamp().compareTo(o1.getTimeStamp());
                if(timeCmp != 0) return timeCmp;
                return o2.getChannelType().compareTo(o1.getChannelType());
                });

        for(NotificationLog log : sortedLogs ){
            System.out.println(log.toString());
        }
    }
}
