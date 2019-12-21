package com.chins.mall.backend.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chins.mall.backend.provider.api.UserService;
import com.chins.mall.backend.provider.api.entity.User;
import com.chins.mall.backend.provider.mapper.UserMapper;
import java.util.List;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public String echo(String s) {
    return "hahahaa " + s;
  }

  @Override
  public List<User> selectAllUsers() {
    return userMapper.selectList(null);
  }

}
