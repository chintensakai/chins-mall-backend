package com.chins.mall.backend.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.chins.mall.backend.provider.mapper"})
public class UmsProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(UmsProviderApplication.class);
  }
}
