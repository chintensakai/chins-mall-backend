package com.chins.mall.backend.provider.user.mgr.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chins.mall.backend.provider.user.mgr.api.PermissionMgrApi;
import com.chins.mall.backend.provider.user.mgr.domain.Permission;
import com.chins.mall.backend.provider.user.mgr.mapper.PermissionMapper;
import java.util.List;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class PermissionMgrService extends ServiceImpl<PermissionMapper, Permission> implements
    PermissionMgrApi {

  @Autowired
  private PermissionMapper permissionMapper;

  @Override
  public List<Permission> selectListByUserId(Long userId) {

    return permissionMapper.selectListByUserId(userId);
  }
}
