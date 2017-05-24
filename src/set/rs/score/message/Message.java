package set.rs.score.message;

import com.sun.media.jfxmedia.logging.Logger;

import java.time.LocalDateTime;

/**
 * Created by set.rs on 24-May-17.
 */
public class Message {
    private LocalDateTime createdTime;
    private MessageType   messageType;
    private boolean       undestroyable;
    private boolean       checkDestroyable;
    String                message;

    public Message(String title, MessageType messageType, boolean isUndestroyable) {
        Logger.logMsg(Logger.INFO, getClass().getName());
        this.createdTime = LocalDateTime.now();
    }

    public long getCreatedTime() {
        return this.getCreatedTime();
    }

    boolean isUndestroyable() {
        return undestroyable;
    }

    boolean isCheckDestroyable() {
        return checkDestroyable;
    }

    void setCheckDestroyable(){
        checkDestroyable = true;
    }
}
