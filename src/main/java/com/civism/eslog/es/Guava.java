package com.civism.eslog.es;

import java.io.Serializable;
import lombok.Data;

/**
 * @author : Guava
 * @version 1.0
 * @projectName：civism-eslog
 * @className：Guava
 * @date 2019-12-14 15:58
 * @E-mail:gongdexing@oxyzgroup.com
 * @Copyright: 版权所有 (C) 2019 蓝鲸淘.
 * @return
 */
@Data
public class Guava implements Serializable {

    private static final long serialVersionUID = -904896511649608951L;

    /**
     * 日志级别
     */
    private String level;

    /**
     * 日志名称
     */
    private String loggerName;

    /**
     * 线程名称
     */
    private String threadName;

    /**
     * 写入时间
     */
    private Long writeTime;


    /**
     * IP地址
     */
    private String ip;

    /**
     * 日志内容
     */
    private Object message;

}
