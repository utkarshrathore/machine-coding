package com.loggerlib.services;

import com.loggerlib.enums.Sink;
import com.loggerlib.models.Message;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class LoggerService {
    private String loggerName;
    private String tsFormat;
    private String loggingLevel;
    private List<Sink> sinkList;
    private HashMap<String, Integer> logLevelMap;

    LoggerService() {
    }

    public LoggerService(String loggerName, String tsFormat, String loggingLevel, int bufferSize) {
        this.loggerName = loggerName;
        this.tsFormat = tsFormat;
        this.loggingLevel = loggingLevel;
        this.sinkList = new LinkedList<>();
        logLevelMap = new HashMap<>();
        logLevelMap.put("DEBUG", 0);
        logLevelMap.put("INFO", 1);
        logLevelMap.put("WARN", 2);
        logLevelMap.put("ERROR", 3);
        logLevelMap.put("FATAL", 4);


        // DEBUG(0),
    }

    abstract void processMessage(Message message);

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getTsFormat() {
        return tsFormat;
    }

    public void setTsFormat(String tsFormat) {
        this.tsFormat = tsFormat;
    }

    public String getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(String loggingLevel) {
        this.loggingLevel = loggingLevel;
    }


    public List<Sink> getSinkType() {
        return sinkList;
    }

    public void setSinkType(List<Sink> sinkType) {
        this.sinkList = sinkType;
    }

    public List<Sink> getSinkList() {
        return sinkList;
    }

    public void setSinkList(List<Sink> sinkList) {
        this.sinkList = sinkList;
    }

    public HashMap<String, Integer> getLogLevelMap() {
        return logLevelMap;
    }

    public void setLogLevelMap(HashMap<String, Integer> logLevelMap) {
        this.logLevelMap = logLevelMap;
    }

    @Override
    public String toString() {
        return "LoggerService{" +
                "loggerName='" + loggerName + '\'' +
                ", tsFormat='" + tsFormat + '\'' +
                ", loggingLevel='" + loggingLevel + '\'' +
                ", sinkType=" + sinkList +
                '}';
    }
}
