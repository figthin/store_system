package com.hwua.storesystem.controller;

import com.hwua.storesystem.exception.HelloException;
import com.hwua.storesystem.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler
    @ResponseBody
    public Result exception(Exception e){
        logger.error("exception : {}", e);
        if (e instanceof HelloException) {
            HelloException helloException = (HelloException) e;
            int code = helloException.getCode();
            String msg = helloException.getMessage();
            return new Result(code,msg);
        }
        String message = e.getMessage();
        if (StringUtils.isEmpty(message)){
            message = "未知错误";
        }
        return new Result(-1,message);
    }

}
