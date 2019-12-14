package com.civism.eslog.appender;

import java.io.Serializable;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

@Plugin(name = "FileAppender", category = "Core", elementType = "appender", printObject = true)
public class FileAppender extends AbstractAppender {

    private String fileName;

    /* 构造函数 */
    public FileAppender(String name, Filter filter, Layout<? extends Serializable> layout,
            boolean ignoreExceptions, String fileName) {
        super(name, filter, layout, ignoreExceptions);
        this.fileName = fileName;

        System.out.println(1111112321);
    }


    public FileAppender(String name, Filter filter,
            Layout<? extends Serializable> layout, boolean ignoreExceptions,
            Property[] properties, String fileName) {
        super(name, filter, layout, ignoreExceptions, properties);
        this.fileName = fileName;
        System.out.println(3212);
    }


    public void append(LogEvent logEvent) {
        System.out.println(1231);
    }

    /*  接收配置文件中的参数 */
    @PluginFactory
    public static FileAppender createAppender(@PluginAttribute("name") String name,
            @PluginAttribute("fileName") String fileName,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
        System.out.println("11111111");
        return new FileAppender(name, filter, layout, ignoreExceptions, fileName);
    }


}