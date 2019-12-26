package com.chins.mall.backend.security.controller;

import com.chins.mall.backend.common.dto.ResponseBase;
import com.chins.mall.backend.security.dto.LoginReqParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Value("${oauth2.grant_type}")
  private String oauth2_grant_type;

  @Value("${oauth2.client_id}")
  private String oauth2_client_id;

  @Value("${oauth2.client_secret}")
  private String oauth2_client_secret;

  @PostMapping("/user/login")
  public ResponseBase userLogin(@RequestBody LoginReqParam loginReqParam) {

//    okhttp请求/oauth/token

    return ResponseBase.success("hahah");
  }
}
