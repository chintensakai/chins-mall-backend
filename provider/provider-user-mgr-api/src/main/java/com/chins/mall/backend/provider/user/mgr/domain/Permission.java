package com.chins.mall.backend.provider.user.mgr.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_permission")
public class Permission {

  @TableId(type = IdType.AUTO)
  private Long id;
  private Long parentId;
  private String name;
  private String description;
  private String created;
  private String updated;
  private String enname;
  private String url;
}
