package com.boot.study1.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService1 {

    public HelloService1(){
        System.out.println("com.boot.study1.service----->" + this.getClass());
    }

}
