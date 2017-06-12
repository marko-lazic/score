/**
 * Created by set.rs on 12-Jun-17.
 */
package set.rs.score;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.*;
import sun.nio.ch.IOUtil;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

class JsonTest {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void myTest() {

        assertEquals(1,1);
    }

    @Test
    void toGson(){
        ClientConfFile clientConfFile = new ClientConfFile();
        clientConfFile.fileSaveLocation = "C:\\SIMADesktopApp";
        clientConfFile.username = "markolazic";
        clientConfFile.password = "51e218c5ec755815c4bebf00d3478fcf";
        clientConfFile.simaHostname = "sima.set.rs";
        clientConfFile.pseudonim = "tavan";
        clientConfFile.language = "SR";
        clientConfFile.customMessagesThreadSleepSec = 1;
        clientConfFile.customMessagesAliveTimeSec = 10;
        clientConfFile.autoLogin = true;
        clientConfFile.maxUploadSpeedUnlimited = false;
        clientConfFile.detailLog = false;
        clientConfFile.sizePerLogFile = 1;
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                switch (field.getName()) {
                    case "fileSaveLocation":
                        return "file save location";
                    case "simaHostname":
                        return "sima hostname";
                    case "customMessagesThreadSleepSec":
                        return "custom messages thread sleep sec";
                    case "customMessagesAliveTimeSec":
                        return "custom messages alive time sec";
                    case "autoLogin":
                        return "auto login";
                    case "maxUploadSpeedUnlimited":
                        return "max upload speed unlimited";
                    case "detailLog":
                        return "detail log";
                    case "sizePerLogFile":
                        return "size per log file MB";
                    default:
                        return field.getName();
                }
            }
        });
        builder.setPrettyPrinting().serializeNulls();
        Gson gson = builder.create();
        //System.out.println(gson.toJson(clientConfFile));
        try ( PrintWriter out = new PrintWriter("SIMAClient.conf") ) {
            out.println(gson.toJson(clientConfFile));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void fromGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                switch (field.getName()) {
                    case "fileSaveLocation":
                        return "file save location";
                    case "simaHostname":
                        return "sima hostname";
                    case "customMessagesThreadSleepSec":
                        return "custom messages thread sleep sec";
                    case "customMessagesAliveTimeSec":
                        return "custom messages alive time sec";
                    case "autoLogin":
                        return "auto login";
                    case "maxUploadSpeedUnlimited":
                        return "max upload speed unlimited";
                    case "detailLog":
                        return "detail log";
                    case "sizePerLogFile":
                        return "size per log file MB";
                    default:
                        return field.getName();
                }
            }
        });
        Gson gson = builder.create();
        ClientConfFile clientConfFile = new ClientConfFile();
        try {
            JsonReader reader = new JsonReader(new FileReader("SIMAClient.conf"));
            clientConfFile = gson.fromJson(reader, ClientConfFile.class);
            System.out.println(gson.toJson(clientConfFile));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void succeedingTest() {
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}