package set.rs.score.message;

/**
 * Created by set.rs on 24-May-17.
 */
public class NotificationMessage extends Message {


    public NotificationMessage(String title, String message) {
        super(title, MessageType.MessageType_Notification, true);
        System.out.println(title.toUpperCase() + ": " + message);
    }
}
