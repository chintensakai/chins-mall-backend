package com.chins.mall.backend.provider.user.mgr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chins.mall.backend.provider.user.mgr.api.UserMgrApi;
import com.chins.mall.backend.provider.user.mgr.domain.User;
import com.chins.mall.backend.provider.user.mgr.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class UserMgrService extends ServiceImpl<UserMapper, User> implements UserMgrApi {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User selectOne(Long id) {
    QueryWrapper queryWrapper = new QueryWrapper();
    queryWrapper.eq("id", id);
    User user = userMapper.selectOne(queryWrapper);

    return user;
  }

  @Override
  public Long insertUser(User user) {
    int insert = userMapper.insert(user);
    if (insert > 0) {
      return user.getId();
    }

    return Long.valueOf(-1);
  }

  @Override
  public User selectOne(String username) {

    QueryWrapper queryWrapper = new QueryWrapper();
    queryWrapper.eq("username", username);

    return userMapper.selectOne(queryWrapper);
  }
}
