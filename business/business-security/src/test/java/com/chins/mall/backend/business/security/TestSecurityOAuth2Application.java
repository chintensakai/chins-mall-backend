package com.chins.mall.backend.business.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSecurityOAuth2Application {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Test
  public void test() {
    System.out.println(passwordEncoder.encode("secret"));
  }
}
