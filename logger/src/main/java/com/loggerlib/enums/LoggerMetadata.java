package com.loggerlib.enums;

public class LoggerMetadata {
    // Extensible to provide more options we might want to attach with logger
    private String fileLocation; // In case sink is a file

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public String toString() {
        return "LoggerMetadata{" +
                "fileLocation='" + fileLocation + '\'' +
                '}';
    }
}
