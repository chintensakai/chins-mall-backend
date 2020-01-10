package com.chins.mall.backend.provider.user.mgr.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chins.mall.backend.provider.user.mgr.domain.Permission;
import java.util.List;

public interface PermissionMgrApi extends IService<Permission> {

  List<Permission> selectListByUserId(Long userId);
}
