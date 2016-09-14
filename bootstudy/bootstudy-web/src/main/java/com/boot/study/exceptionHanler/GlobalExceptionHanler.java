package com.boot.study.exceptionHanler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 捕获controller抛出的所有异常
@ControllerAdvice
public class GlobalExceptionHanler {

    @ExceptionHandler
    public void defaluErrorHanler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        System.out.println("GlobalExceptionHandler.defaultErrorHandler()");
    }

}
