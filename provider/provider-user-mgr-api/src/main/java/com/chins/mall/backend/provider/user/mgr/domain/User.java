package com.chins.mall.backend.provider.user.mgr.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {

  @TableId(type = IdType.AUTO)
  private Long id;
  private String username;
  private String password;
  private String phone;
  private String email;
  private String created;
  private String updated;
}
