package com.club.subject.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * packageName com.club.subject
 * @className SubjectApplication
 * @author zh
 * @version 1.0
 * @date 2025-08-16
 * @description TODO 刷题微服务启动类
 */
@SpringBootApplication(scanBasePackages = {"com.club.subject"})
@MapperScan("com.club.subject.**.mapper")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class, args);
    }
}
