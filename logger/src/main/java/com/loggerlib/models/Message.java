package com.loggerlib.models;

public class Message {
    private String content;
    private String logLevel;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", logLevel='" + logLevel + '\'' +
                '}';
    }
}
