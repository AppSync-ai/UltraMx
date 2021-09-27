package com.mt.lamdatrack.Rate;

public class RatesReq {
    String CURRENCY, PRICE, CHANGE, CHANGE_percent, OPEN, PREV_CLOSE, LOW_HIGH;

    public RatesReq(String CURRENCY, String PRICE, String CHANGE, String CHANGE_percent, String OPEN, String PREV_CLOSE, String LOW_HIGH) {
        this.CURRENCY = CURRENCY;
        this.PRICE = PRICE;
        this.CHANGE = CHANGE;
        this.CHANGE_percent = CHANGE_percent;
        this.OPEN = OPEN;
        this.PREV_CLOSE = PREV_CLOSE;
        this.LOW_HIGH = LOW_HIGH;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getCHANGE() {
        return CHANGE;
    }

    public void setCHANGE(String CHANGE) {
        this.CHANGE = CHANGE;
    }

    public String getCHANGE_percent() {
        return CHANGE_percent;
    }

    public void setCHANGE_percent(String CHANGE_percent) {
        this.CHANGE_percent = CHANGE_percent;
    }

    public String getOPEN() {
        return OPEN;
    }

    public void setOPEN(String OPEN) {
        this.OPEN = OPEN;
    }

    public String getPREV_CLOSE() {
        return PREV_CLOSE;
    }

    public void setPREV_CLOSE(String PREV_CLOSE) {
        this.PREV_CLOSE = PREV_CLOSE;
    }

    public String getLOW_HIGH() {
        return LOW_HIGH;
    }

    public void setLOW_HIGH(String LOW_HIGH) {
        this.LOW_HIGH = LOW_HIGH;
    }
}