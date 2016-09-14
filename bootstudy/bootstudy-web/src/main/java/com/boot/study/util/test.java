package com.boot.study.util;

import com.boot.study.externalStaticSource.AccessExternalSource;

public class test {

    public static void main(String[] args) {
        System.out.println(SpringUtil.getBean(AccessExternalSource.class));
    }

}
