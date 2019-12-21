package com.chins.mall.backend.service.controller;

import com.chins.mall.backend.provider.api.UserService;
import com.chins.mall.backend.provider.api.entity.User;
import java.util.List;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

  @Reference(version = "1.0.0")
  private UserService userService;

  @GetMapping("/all-users")
  public List<User> getAllUsers() {
    return userService.selectAllUsers();
  }
}
