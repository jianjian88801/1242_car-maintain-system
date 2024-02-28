package com.xunmaw.car.maintain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类
 *
 * @author 2023/2/5 15:48
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xunmaw.car.maintain.mapper")
public class CarMaintainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarMaintainApplication.class, args);
    }

}
