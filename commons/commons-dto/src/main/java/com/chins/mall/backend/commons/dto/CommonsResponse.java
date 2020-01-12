package com.chins.mall.backend.commons.dto;

import lombok.Data;

@Data
public class CommonsResponse<T> {

  private int code;
  private String message;
  private T data;

  public CommonsResponse(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public CommonsResponse() {
  }

  public static <T> CommonsResponse success(T data) {

    CommonsResponse commonsResponse = new CommonsResponse();
    commonsResponse.setCode(BaseStatusEnum.SUCCESS.getIndex());
    commonsResponse.setMessage(BaseStatusEnum.SUCCESS.getMsg());
    commonsResponse.setData(data);

    return commonsResponse;
  }

  public static <T> CommonsResponse failed(T data) {

    System.out.println("--------------- " + data);

    CommonsResponse commonsResponse = new CommonsResponse();
    commonsResponse.setCode(BaseStatusEnum.INTERNAL_SERVER_ERROR.getIndex());
    commonsResponse.setMessage(BaseStatusEnum.INTERNAL_SERVER_ERROR.getMsg());
    commonsResponse.setData(data);

    return commonsResponse;
  }
}
