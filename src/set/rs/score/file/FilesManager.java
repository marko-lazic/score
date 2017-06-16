package set.rs.score.file;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by set.rs on 15-Jun-17.
 */
public class FilesManager {
    private FilesManager instance;
    private boolean instanceFlag;
    private List<OriginalFile> originalFiles = new ArrayList<>();
    private int originalFilesMaxFreeID = 1;
    private int openFilesLocationFreeID = 1;
    private List<String> charWhiteList = new ArrayList<>();
    private List<String> fileNameCharExcapeList = new ArrayList<>();
    private List<String> pathCharEscapeList = new ArrayList<>();
    private List<String> pathCharWhiteList = new ArrayList<>();



    private int getOriginalFilesNextFreeID() {
        return 0;
    }

    private int getOpenFilesLocationNextFreeID() {
        return 0;
    }

    private void fillEscapeAndWhiteLists() {

    }

    private void restoreModifiedFiles() {

    }

    private List<OriginalFile> getOriginalFilesFromJson() {
        return new ArrayList<>();
    }

    private void getModifyJsonArray() {

    }

    // private void updateO


    private FilesManager() {

    }

    private FilesManager(final FilesManager manager) {

    }


}
