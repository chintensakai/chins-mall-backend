package com.chins.mall.backend.provider.user.mgr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chins.mall.backend.provider.user.mgr.domain.Permission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper extends BaseMapper<Permission> {

  List<Permission> selectListByUserId(@Param("userId") Long UserId);
}
