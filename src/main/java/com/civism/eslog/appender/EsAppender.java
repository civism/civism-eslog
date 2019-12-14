package com.civism.eslog.appender;

import com.civism.eslog.es.Guava;
import com.civism.eslog.es.GuavaClient;
import java.net.InetAddress;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.stereotype.Component;

/**
 * @author : Guava
 * @version 1.0
 * @projectName：civism-eslog
 * @className：EsAppender
 * @date 2019-12-13 11:48
 * @E-mail:gongdexing@oxyzgroup.com
 * @Copyright: 版权所有 (C) 2019 蓝鲸淘.
 * @return
 */
@Component
public class EsAppender extends AppenderSkeleton {


    /**
     * 打印日志核心方法
     */
    @Override
    protected void append(LoggingEvent loggingEvent) {
        Level level = loggingEvent.getLevel();
        String loggerName = loggingEvent.getLoggerName();
        Object message = loggingEvent.getMessage();
        String threadName = loggingEvent.getThreadName();
        long timeStamp = loggingEvent.getTimeStamp();

        Guava guava = new Guava();
        guava.setLevel(level.toString());
        guava.setLoggerName(loggerName);
        guava.setThreadName(threadName);
        guava.setWriteTime(DateFormatUtils.format(timeStamp, "yyyy-MM-dd HH:mm:ss"));
        try {
            InetAddress address = InetAddress.getLocalHost();
            guava.setIp(address.getHostAddress());
        } catch (Exception e) {

        }
        guava.setMessage(message);
        ClientInterface client = GuavaClient.getClient();
        client.addDocument(GuavaClient.GUAVA, GuavaClient.GUAVA, guava);
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        GuavaClient.close();
    }

    /**
     * 是否需要按格式输出文本
     */
    @Override
    public boolean requiresLayout() {
        System.out.println("3333");
        return false;
    }


}
