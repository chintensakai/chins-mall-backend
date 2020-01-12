package com.chins.mall.backend.business.security.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LoginUserInfo implements Serializable {

  private String username;
  private String avatar;
}
