package com.civism.eslog.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

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
public class EsAppender extends AppenderSkeleton {

    private String hosts;

    /**
     * 打印日志核心方法
     */
    @Override
    protected void append(LoggingEvent loggingEvent) {
        System.out.println(112222);
        System.out.println(hosts);
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        System.out.println("21111");
    }

    /**
     * 是否需要按格式输出文本
     */
    @Override
    public boolean requiresLayout() {
        System.out.println("3333");
        return false;
    }


    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }
}
