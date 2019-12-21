package com.chins.mall.backend.provider.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chins.mall.backend.provider.api.entity.User;
import java.util.List;

public interface UserService extends IService<User> {

  String echo(String s);

  List<User> selectAllUsers();

  int insertUser(User user);
}
