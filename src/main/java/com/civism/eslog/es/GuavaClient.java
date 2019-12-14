package com.civism.eslog.es;

import java.util.HashMap;
import java.util.Map;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.ElasticSearchBoot;
import org.frameworkset.elasticsearch.client.ClientInterface;

/**
 * @author : Guava
 * @version 1.0
 * @projectName：civism-eslog
 * @className：GuavaLog
 * @date 2019-12-14 16:23
 * @E-mail:gongdexing@oxyzgroup.com
 * @Copyright: 版权所有 (C) 2019 蓝鲸淘.
 * @return
 */
public class GuavaClient {

    /**
     * 索引
     */
    public static final String GUAVA = "guava";

    /**
     * mapper 路径
     */
    private static final String MAPPER_PATH = "esmapper/guava.xml";

    private static ClientInterface client;


    public static ClientInterface getClient() {
        if (client == null) {
            synchronized (GUAVA) {
                if (client == null) {
                    init();
                    client = ElasticSearchHelper.getConfigRestClientUtil(MAPPER_PATH);
                    if (!client.existIndice(GUAVA)) {
                        client.createIndiceMapping(GUAVA, "createGuavaIndex");
                    }
                }
            }
        }
        return client;
    }


    public static void close() {
        if (client != null) {
            client.closeIndex(GUAVA);
        }
    }

    private static void init() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("elasticUser", "");
        properties.put("elasticPassword", "");
        properties.put("elasticsearch.rest.hostNames", "esapi.bw365.net:9200");
        //是否在控制台打印dsl语句，log4j组件日志级别为INFO或者DEBUG
        properties.put("elasticsearch.showTemplate", "true");
        properties.put("elasticsearch.discoverHost", "true");
        properties.put("http.timeoutSocket", "60000");
        properties.put("http.timeoutConnection", "40000");
        properties.put("http.connectionRequestTimeout", "70000");
        ElasticSearchBoot.boot(properties);
    }

}
