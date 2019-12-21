package com.chins.mall.backend.provider.test;

import com.chins.mall.backend.provider.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUsm {

  @Autowired
  private UserService userService;

  @Test
  public void test() {
    System.out.println(userService.selectAllUsers());
  }
}
