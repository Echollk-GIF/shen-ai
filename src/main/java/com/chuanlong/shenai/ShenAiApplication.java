package com.chuanlong.shenai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.chuanlong.shenai.mapper")
@SpringBootApplication
public class ShenAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShenAiApplication.class, args);
    }

}
