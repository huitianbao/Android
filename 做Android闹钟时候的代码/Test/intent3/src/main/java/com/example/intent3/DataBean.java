package com.example.intent3;

import java.io.Serializable;

/**
 * Created by 16221 on 2018/2/8.
 */

public class DataBean implements Serializable {
    private String sex;
    private String name;
    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



}
