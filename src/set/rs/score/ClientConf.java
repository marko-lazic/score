package set.rs.score;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by set.rs on 24-May-17.
 */


public class ClientConf {
    private static ClientConf   clientConf;
    private static boolean      instanceFlag;
    //boost::mutext             confMutex;
    private String              fileSaveLocation;
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



    public ClientConf instance() {
        if (!instanceFlag) {
            clientConf      = new ClientConf();
            instanceFlag    = true;
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

        final char alphanum[]   =
                                ("0123456789" +
                                 "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                 "abcdefghijklmnopqrstuvwxyz")
                                .toCharArray();

        Random random           = new Random();

        for (int i = 0; i < 10; ++i) {
            logFilePrefix += alphanum[random.nextInt(alphanum.length)];
        }

        populate();
    }

    private FieldNamingStrategy SIMANamingStrategy() {
        return new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                switch (field.getName()) {
                    case "fileSaveLocation":                return "file save location";
                    case "simaHostname":                    return "sima hostname";
                    case "customMessagesThreadSleepSec":    return "custom messages thread sleep sec";
                    case "customMessagesAliveTimeSec":      return "custom messages alive time sec";
                    case "autoLogin":                       return "auto login";
                    case "maxUploadSpeedUnlimited":         return "max upload speed unlimited";
                    case "detailLog":                       return "detail log";
                    case "sizePerLogFile":                  return "size per log file MB";
                    default:                                return field.getName();
                }
            }
        };
    }

    private void populate() {
        Gson gson = new GsonBuilder().setFieldNamingStrategy(SIMANamingStrategy()).create();
        ClientConfFile clientConfFile;
        try (JsonReader reader = new JsonReader(new FileReader(CONF_FILE_NAME))) {

            clientConfFile = gson.fromJson(reader, ClientConfFile.class);
            fileSaveLocation                = clientConfFile.fileSaveLocation;
            username                        = clientConfFile.username;
            password                        = clientConfFile.password;
            simaHostname                    = clientConfFile.simaHostname;
            pseudonim                       = clientConfFile.pseudonim;
            language                        = clientConfFile.language;
            customMessagesThreadSleepSec    = clientConfFile.customMessagesThreadSleepSec;
            customMessagesAliveTimeSec      = clientConfFile.customMessagesAliveTimeSec;
            maxUploadSPeedUnlimited         = clientConfFile.maxUploadSpeedUnlimited;
            detailLog                       = clientConfFile.detailLog;
            sizePerLogFileMB                = clientConfFile.sizePerLogFile;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeToFile(){
        ClientConfFile clientConfFile               = new ClientConfFile();
        clientConfFile.fileSaveLocation             = fileSaveLocation;
        clientConfFile.username                     = username;
        clientConfFile.password                     = password;
        clientConfFile.simaHostname                 = simaHostname;
        clientConfFile.pseudonim                    = pseudonim;
        clientConfFile.language                     = language;
        clientConfFile.customMessagesThreadSleepSec = customMessagesThreadSleepSec;
        clientConfFile.customMessagesAliveTimeSec   = customMessagesAliveTimeSec;
        clientConfFile.autoLogin                    = autoLogin;
        clientConfFile.maxUploadSpeedUnlimited      = maxUploadSPeedUnlimited;
        clientConfFile.detailLog                    = detailLog;
        clientConfFile.sizePerLogFile               = sizePerLogFileMB;

        Gson gson  = new GsonBuilder()
                        .setFieldNamingStrategy(SIMANamingStrategy())
                        .setPrettyPrinting().serializeNulls()
                        .create();
        try ( PrintWriter out = new PrintWriter(CONF_FILE_NAME) ) {}
        catch (Exception e) { System.out.println(e.getMessage()); }
    }
}

