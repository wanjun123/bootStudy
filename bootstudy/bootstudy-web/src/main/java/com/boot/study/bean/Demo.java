package com.boot.study.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class Demo {

    @JSONField(serialize = false)
    private long   id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
