package day3_notification_system;

import java.time.LocalDateTime;

public class NotificationLog {
    private final String channelType;
    private final String message;
    private final LocalDateTime timeStamp;

    public NotificationLog(String channelType, String message, LocalDateTime timeStamp) {
        if(channelType == null || channelType.isBlank()){
            throw new IllegalArgumentException("ChannelType is null or blank");
        }

        if(message == null || message.isBlank()){
            throw new IllegalArgumentException("Message is null or blank");
        }

        if(timeStamp == null){
            throw new IllegalArgumentException("TimeStamp is null or blank");
        }

        this.channelType = channelType;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getChannelType() {
        return channelType;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "NotificationLog{" +
                "channelType='" + channelType + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
