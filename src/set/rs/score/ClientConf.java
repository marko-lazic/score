package set.rs.score;

import java.util.Date;
import java.util.Random;

/**
 * Created by set.rs on 24-May-17.
 */


public class ClientConf {
    private static ClientConf   clientConf;
    private static boolean      instanceFlag;
    //boost::mutext             confMutex;
    private String              flieSaveLocation;
    private String              username;
    private String              password;
    private String              simaHostname;
    private String              pseudonim;
    private String              language = "SR";
    private int                 customMessagesThreadSleepSec = 1;
    private int                 customMessagesAliveTimeSec = 10;
    private int                 maxPacketSizeKB = 64;
    private int                 maxDownloadSpeedKB = 64;
    private int                 maxUploadSpeedKB = 64;
    private int                 sizePerLogFileMB = 1;
    private boolean             autoLogin = true;
    private boolean             maxDownloadSpeedUnlimited = false;
    private boolean             maxUploadSPeedUnlimited = false;
    private boolean             detailLog = false;
    private int                 maxNumOfLogFiles = 10;
    private String              clientAppVersionMajor;
    private String              clientAppVersionMinor;
    private String              clientAppVersionPostfix;
    private String              clientAppBuildDate;
    private String              confFilePath;
    private String              execDirLocation;
    private String              connector;
    //boost::mutex              logMutex;
    private String              logDirPath;
    private String              logFilePrefix;
    private int                 preformLogCount = 0;
    private boolean             stopLogging  = false;
    private final String        CONF_FILE_NAME = "SIMAClient.conf";;

    private void checkLogFilesSizes() {

    }

    private void populate() {

    }

    public ClientConf instance() {
        if (!instanceFlag) { // TODO: obesiću se
            clientConf = new ClientConf();
            instanceFlag = true;
        }
        return clientConf;
    }

    private ClientConf() {
        clientAppVersionMajor   = "0";
        clientAppVersionMinor   = "1";
        clientAppVersionPostfix = "";
        clientAppBuildDate      = "25 Maj 2017"; // TODO: compile date
        clientAppVersionPostfix = "ssl";
        execDirLocation         = System.getProperty("user.dir");
        confFilePath            = execDirLocation + CONF_FILE_NAME;
        logDirPath              = execDirLocation + "logs";

        final char alphanum[] =
                ("0123456789" +
                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "abcdefghijklmnopqrstuvwxyz")
                        .toCharArray();

        Random random = new Random();

        for (int i = 0; i < 10; ++i) {
            logFilePrefix += alphanum[random.nextInt(alphanum.length)];
        }

        populate();
    }
}
