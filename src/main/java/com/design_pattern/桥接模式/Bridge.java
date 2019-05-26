package com.design_pattern.桥接模式;

/**
 * Created by root on 2019/5/26.
 */
public abstract  class Bridge {

    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
