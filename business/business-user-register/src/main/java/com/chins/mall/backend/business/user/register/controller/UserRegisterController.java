package com.chins.mall.backend.business.user.register.controller;

import com.chins.mall.backend.provider.user.mgr.api.UserMgrApi;
import com.chins.mall.backend.provider.user.mgr.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegisterController {

  @Reference(version = "1.0.0")
  private UserMgrApi userMgrApi;

  @GetMapping("/user/{id}")
  public User queryUserById(@PathVariable Long id) {

    User user = userMgrApi.selectOne((long) 1);
    return user;
  }
}
