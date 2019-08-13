package com.hwua.storesystem.util;

public enum  ExceptionCode {

    INVALID__PASSWORD(101,"密码错误"),
    USERNAME_NOT_EXISTS(102,"用户不存在"),
    USERNAME_ALREADY_EXISTS(103,"用户已经存在");

    private int code;
    private String msg;

    ExceptionCode(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
