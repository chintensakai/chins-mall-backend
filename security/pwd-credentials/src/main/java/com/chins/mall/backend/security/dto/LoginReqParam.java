package com.chins.mall.backend.security.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LoginReqParam implements Serializable {

  private String username;
  private String password;
}
