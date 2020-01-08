package com.chins.mall.backend.provider.user.mgr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chins.mall.backend.provider.user.mgr.api.UserMgrApi;
import com.chins.mall.backend.provider.user.mgr.domain.User;
import com.chins.mall.backend.provider.user.mgr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
}
