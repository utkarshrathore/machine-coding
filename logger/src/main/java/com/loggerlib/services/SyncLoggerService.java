package com.loggerlib.services;

import com.loggerlib.enums.Sink;
import com.loggerlib.models.Message;
import com.loggerlib.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SyncLoggerService extends LoggerService {
    SyncLoggerService(String loggerName, String tsFormat, String loggingLevel, int bufferSize) {
        super(loggerName, tsFormat, loggingLevel, bufferSize);
    }

    @Override
    public void processMessage(Message message) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.getTsFormat());
        HashMap<String, Integer> logLevelMap = this.getLogLevelMap();
        for(Sink s : this.getSinkType()) {
            if(s.equals(Sink.S_STDOUT))
                if(logLevelMap.get(this.getLoggingLevel()) <= logLevelMap.get(message.getLogLevel())) {
                System.out.println(String.format(Constants.LOG_MESSAGE_FORMAT,
                        simpleDateFormat.format(new Date()),
                        message.getLogLevel(),
                        message.getLogLevel()
                        ));
            }
        }
    }
}
