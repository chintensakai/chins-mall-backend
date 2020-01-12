package com.chins.mall.backend.business.security.dto;

import java.io.Serializable;
import lombok.Data;

/***
 * 登录参数
 */

@Data
public class LoginParam implements Serializable {

  private String username;
  private String password;
}
