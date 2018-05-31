package com.joy.java.mybatis.model;

public class BkKskscc extends BkKsksccKey {
    private String ksksccZw;

    private String ksksccTzzw;

    public String getKsksccZw() {
        return ksksccZw;
    }

    public void setKsksccZw(String ksksccZw) {
        this.ksksccZw = ksksccZw == null ? null : ksksccZw.trim();
    }

    public String getKsksccTzzw() {
        return ksksccTzzw;
    }

    public void setKsksccTzzw(String ksksccTzzw) {
        this.ksksccTzzw = ksksccTzzw == null ? null : ksksccTzzw.trim();
    }
}