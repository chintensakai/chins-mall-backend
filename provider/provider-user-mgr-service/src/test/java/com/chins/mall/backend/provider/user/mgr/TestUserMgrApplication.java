package com.chins.mall.backend.provider.user.mgr;

import com.chins.mall.backend.provider.user.mgr.domain.User;
import com.chins.mall.backend.provider.user.mgr.service.UserMgrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserMgrApplication {

  @Autowired
  UserMgrService userMgrService;

  @Test
  public void test() {

    User user = userMgrService.selectOne((long) 1);

    System.out.println(user);
  }
}
