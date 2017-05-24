package set.rs.score.message;

/**
 * Created by set.rs on 24-May-17.
 */

public class InfoMessage extends Message {

    public InfoMessage(String title, String message) {
        super(title, MessageType.MessageType_Info, false);
        System.out.println(title.toUpperCase() + ": " + message);
    }
}
