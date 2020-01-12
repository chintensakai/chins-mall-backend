package com.chins.mall.backend.commons.dto;

public enum BaseStatusEnum {

  SUCCESS("success!", 200),

  INTERNAL_SERVER_ERROR("Internal Server Error!", 500),

  NOT_FOUND("404 not found!", 404),

  UNAUTHORIZED("401 Unauthorized!", 401);

  private String msg;

  private int index;

  BaseStatusEnum(String msg, int index) {
    this.msg = msg;
    this.index = index;
  }

  public String getMsg() {
    return msg;
  }

  public int getIndex() {
    return index;
  }
}
