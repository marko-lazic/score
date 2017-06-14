package set.rs.score.file;


/**
 * Created by set.rs on 14-Jun-17.
 */
public class OriginalFile {
    private enum        OrigStatus                  { waiting, ready };
    private             OrigStatus status =         OrigStatus.waiting;
    private long        internalID;
    private long        fileVersionID;
    private String      displayFileName;
    private String      md5HashValue;
    private long  fileSize;
    private long  lastWriteTime;
    private boolean     requestByFileVersion;
    private String      modifyDir;

    private boolean     locked =                    false;
    private boolean     lockedByLoggedInUser =      false;
    private String      lockedUserDisplayName;

    private boolean     isOpen =                    false;
    private boolean     isModified =                false;
    private boolean     isReadOnly =                true;
    private long        modificationNumber =        0;
    private long  modifiedFileSize;
    private String modifiedMD5HashValue;

    public OriginalFile(long internalID, long fileVersionID,
                            final String displayFileName, final String md5HashValue,
                            long fileSize, final String modifyDir,
                            boolean requestByFileVersion)
    {
        this.internalID = internalID;
        this.fileVersionID = fileVersionID;
        this.displayFileName = displayFileName;
        this.md5HashValue = md5HashValue;
        this.fileSize = fileSize;
        this.modifyDir = modifyDir;
        this.requestByFileVersion = requestByFileVersion;


    }

    public boolean equals(final OriginalFile file) {
        if (internalID == file.getInternalID()
                && fileVersionID == file.getFileVersionID()
                && displayFileName == file.getDisplayFileName()
                && md5HashValue == file.getMD5Hash()
                && fileSize == file.getFileSize())
            return true;
        return false;
    }

    public boolean      isOpen()                    {return isOpen;}
    public boolean      isModified()                {return (isModified && isOpen) ? true : false;}
    public boolean      isReadOnly()                {return isReadOnly;}
    public boolean      isRequestedByFileVersion()  {return requestByFileVersion;}

    public boolean      isStatusReady()             {return (status.equals(OrigStatus.ready)) ? true : false;}

    public long         getFileVersionID()          {return fileVersionID;}
    public long         getInternalID()             {return internalID;}
    public long         getFileSize()               {return fileSize;}
    public String       getMD5Hash()                {return md5HashValue;}
    public long         getLastWriteTime()          {return lastWriteTime;}
    public String       getDisplayFileName()        {return displayFileName;}
    public long         getModificationNumber()     {return modificationNumber;}
    public String       getModifyDir()              {return modifyDir;}
    public long         getModifiedFileSize()       {return modifiedFileSize;}
    public String       getModifiedMD5Hash()        {return modifiedMD5HashValue;}

    private void setDisplayName(final String displayFileName) {
        this.displayFileName = displayFileName;
    }

    public void setMD5Hash(final String md5HashValue) {
        this.md5HashValue = md5HashValue;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setOpen(long lastWriteTime) {
        isOpen = true;
        this.lastWriteTime = lastWriteTime;
    }

    public void setModified(long fileSize, final String MD5hash, long writeTime){
        isOpen = true;
        isModified = true;
        modificationNumber++;
        modifiedFileSize = fileSize;
        modifiedMD5HashValue = MD5hash;
        lastWriteTime = writeTime;
    }

    public void setRequestedByFileVersion(boolean requestByFileVersion) {
        this.requestByFileVersion = requestByFileVersion;
    }

    public void setStatusReady() {
        this.status = OrigStatus.ready;
    }

    public void setStatusWaiting() {
        this.status = OrigStatus.waiting;
    }

    public void setModifyDir(final String modifyDir) {
        this.modifyDir = modifyDir;
    }

    public void setReadOnly() {
        isReadOnly = true;
    }

    public void removeReadOnly() {
        isReadOnly = false;
    }

    public void setClosed() {
        isOpen = false;
    }

    public void setUnmodified() {
        isModified = false;
        modificationNumber = 0;
        modifiedFileSize = fileSize;
        modifiedMD5HashValue = md5HashValue;
    }


}
