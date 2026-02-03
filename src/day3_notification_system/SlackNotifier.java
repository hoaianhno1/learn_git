package day3_notification_system;

public class SlackNotifier implements Notifier{
   private final String channel;

    public SlackNotifier(String channel) {
        if(channel == null || channel.isBlank()){
            throw new IllegalArgumentException("Channel is null or blank");
        }
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    @Override
    public String send(String message) {
        return "Chanel to " + this.getChannel() + "; Message:" + message;
    }
}
