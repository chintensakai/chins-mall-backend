package com.chins.mall.backend.business.security.dto;

import lombok.Data;

@Data
public class TokenEntity {

  private String access_token;
  private String token_type;
  private String refresh_token;
  private Long expires_in;
  private String  scope;
}
