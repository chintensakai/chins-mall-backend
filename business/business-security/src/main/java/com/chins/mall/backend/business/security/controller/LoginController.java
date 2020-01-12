package com.chins.mall.backend.business.security.controller;

import com.chins.mall.backend.business.security.dto.LoginParam;
import com.chins.mall.backend.business.security.dto.LoginUserInfo;
import com.chins.mall.backend.business.security.dto.TokenEntity;
import com.chins.mall.backend.commons.dto.BaseStatusEnum;
import com.chins.mall.backend.commons.dto.CommonsResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

  @Value("${business.oauth2.grant_type}")
  private String oauth2_grant_type;

  @Value("${business.oauth2.client_id}")
  private String oauth2_client_id;

  @Value("${business.oauth2.client_secret}")
  private String oauth2_client_secret;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private TokenStore tokenStore;

  @PostMapping("/user/login")
  public CommonsResponse login(@RequestBody LoginParam loginParam) {

    String tokenUrl = "http://localhost:8091/oauth/token";
    MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
    multiValueMap.add("username", loginParam.getUsername());
    multiValueMap.add("password", loginParam.getPassword());
    multiValueMap.add("grant_type", oauth2_grant_type);
    multiValueMap.add("client_id", oauth2_client_id);
    multiValueMap.add("client_secret", oauth2_client_secret);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(multiValueMap, headers);
    TokenEntity tokenEntity;
    try {
      tokenEntity = restTemplate.postForObject(tokenUrl, entity, TokenEntity.class);
    } catch (Exception e) {
      tokenEntity = null;
    }

    if (null == tokenEntity) {
      return new CommonsResponse(BaseStatusEnum.UNAUTHORIZED.getIndex(),
          BaseStatusEnum.UNAUTHORIZED.getMsg(), null);
    }
    return new CommonsResponse(BaseStatusEnum.SUCCESS.getIndex(), BaseStatusEnum.SUCCESS.getMsg(),
        tokenEntity);
  }

  /***
   * 根据token获取用户信息
   * @return
   */
  @GetMapping("/user/info")
  public CommonsResponse loginInfo() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String name = authentication.getName();

    LoginUserInfo loginUserInfo = new LoginUserInfo();
    loginUserInfo.setUsername(name);

    return new CommonsResponse(BaseStatusEnum.SUCCESS.getIndex(), BaseStatusEnum.SUCCESS.getMsg(),
        loginUserInfo);
  }

  /***
   * 注销，删除tokenStore中的token
   */
  @PostMapping("/user/logout")
  public CommonsResponse logout(HttpServletRequest request) {
    String access_token = request.getParameter("access_token");
    OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(access_token);
    tokenStore.removeAccessToken(oAuth2AccessToken);

    return new CommonsResponse(BaseStatusEnum.SUCCESS.getIndex(), BaseStatusEnum.SUCCESS.getMsg(),
        null);
  }
}
