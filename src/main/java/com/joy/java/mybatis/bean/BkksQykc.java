package com.joy.java.mybatis.bean;

import com.joy.java.mybatis.model.BkKs;
import com.joy.java.mybatis.model.QyKc;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.mybatis.bean
 * @Author: Joy
 * @Date: 2018-05-30 18:00
 * @Description: TODO
 **/
public class BkksQykc {
    private BkKs bkKs;
    private QyKc qyKc;

    public BkKs getBkKs() {
        return bkKs;
    }

    public void setBkKs(BkKs bkKs) {
        this.bkKs = bkKs;
    }

    public QyKc getQyKc() {
        return qyKc;
    }

    public void setQyKc(QyKc qyKc) {
        this.qyKc = qyKc;
    }
}
