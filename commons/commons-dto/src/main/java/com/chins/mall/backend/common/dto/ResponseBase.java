package com.chins.mall.backend.common.dto;

import lombok.Data;

@Data
public class ResponseBase<T> {

  private int code;
  private String message;
  private T data;

  public ResponseBase(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public ResponseBase() {
  }

  public static <T> ResponseBase success(T data) {

    ResponseBase responseBase = new ResponseBase();
    responseBase.setCode(BaseStatusEnum.SUCCESS.getIndex());
    responseBase.setMessage(BaseStatusEnum.SUCCESS.getMsg());
    responseBase.setData(data);

    return responseBase;
  }

  public static <T> ResponseBase failed(T data) {

    System.out.println("--------------- " + data);

    ResponseBase responseBase = new ResponseBase();
    responseBase.setCode(BaseStatusEnum.INTERNAL_SERVER_ERROR.getIndex());
    responseBase.setMessage(BaseStatusEnum.INTERNAL_SERVER_ERROR.getMsg());
    responseBase.setData(data);

    return responseBase;
  }
}
