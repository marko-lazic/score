package set.rs.score.file;

/**
 * Created by set.rs on 24-May-17.
 */
public class FileInfo {
    private int     fileVersionID;
    private String  displayFileName;
    private String  cryptedFileName;
    private String  hashValue;
    private int     fileSize;
    int             modificationsNumber;


    public FileInfo(int id, String displayName,
                    String cryptedName, String
                            hash, int size) {

        this.fileVersionID =        id;
        this.displayFileName =      displayName;
        this.cryptedFileName =      cryptedName;
        this.hashValue =            hash;
    }

    public int getFileVersionID() {
        return fileVersionID;
    }

    public String getDisplayFileName() {
        return displayFileName;
    }

    public String getCryptedFileName() {
        return cryptedFileName;
    }

    public String getHashValue() {
        return hashValue;
    }

    public int getFileSize() {
        return fileSize;
    }
}
