package com.civism.eslog;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.civism.eslog")
public class CivismEslogApplication {

    private static final Logger logger = LoggerFactory.getLogger(CivismEslogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CivismEslogApplication.class, args);

        logger.info("springboot 启动成功");

    }

}
