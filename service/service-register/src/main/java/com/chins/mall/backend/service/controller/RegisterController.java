package com.chins.mall.backend.service.controller;

import com.chins.mall.backend.common.dto.ResponseBase;
import com.chins.mall.backend.provider.api.UserService;
import com.chins.mall.backend.provider.api.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

  @Reference(version = "1.0.0")
  private UserService userService;

  @GetMapping("/all-users")
  public ResponseBase getAllUsers() {
    return ResponseBase.success(userService.selectAllUsers());
  }

  @PostMapping("/register")
  public ResponseBase userRegister(@RequestBody User user) {
    return ResponseBase.success(userService.insertUser(user));
  }
}
