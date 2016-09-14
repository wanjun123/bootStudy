package com.boot.study.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloService(){
        System.out.println("com.boot.study.service----->" + this.getClass());
    }

}
