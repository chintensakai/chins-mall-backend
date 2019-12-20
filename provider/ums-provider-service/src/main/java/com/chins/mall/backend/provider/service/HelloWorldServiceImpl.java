package com.chins.mall.backend.provider.service;

import com.chins.mall.backend.provider.api.HelloWorldService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class HelloWorldServiceImpl implements HelloWorldService {

  @Override
  public String echo(String s) {
    return "hahahaa " + s;
  }
}
