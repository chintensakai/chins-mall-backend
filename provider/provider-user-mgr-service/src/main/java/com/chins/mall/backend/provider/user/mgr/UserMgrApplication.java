package com.chins.mall.backend.provider.user.mgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chins.mall.backend.provider.user.mgr.mapper")
public class UserMgrApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserMgrApplication.class, args);
  }
}
