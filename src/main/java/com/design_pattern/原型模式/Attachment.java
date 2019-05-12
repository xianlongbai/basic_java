package com.design_pattern.原型模式;

import java.io.Serializable;

/**
 * Created by root on 2019/5/12.
 * 附件类
 */
public class Attachment implements Serializable{

    private String name; //附件名

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void download() {
        System.out.println("下载附件，文件名为" + name);
    }
}
