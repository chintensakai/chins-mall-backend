package com.chins.mall.backend.provider.user.mgr.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chins.mall.backend.provider.user.mgr.domain.User;

public interface UserMgrApi extends IService<User> {

  User selectOne(Long id);

  Long insertUser(User user);
}
