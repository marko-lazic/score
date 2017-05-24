package set.rs.score;

/**
 * Created by set.rs on 24-May-17.
 */
public class ClientConf {
    private ClientConf(){}
    private static ClientConf clientConf;
    private static boolean instanceFlag;
    //boost::mutext confMutex;
    private String flieSaveLocation;
    private String username;
    private String password;
    private String simaHostname;
    private String pseudonim;
    private String language = "SR";
    long customMessagesThreadSleepSec = 1;

}
