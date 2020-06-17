package com.leg.kafkatest;

import java.util.Date;

public class Flight {
    private String FLIGHT_NO;
    private String DEP_CT;
    private String ARR_CT;
    private String DEP_SCHEDULED;
    private String ARR_SCHEDULED;
    private String FLIGHT_STATE;
    private String PRICE;
    private String DATE;
    private String sendTime;

    public Flight() {
    }

    public Flight(String FLIGHT_NO, String DEP_CT, String ARR_CT, String DEP_SCHEDULED, String ARR_SCHEDULED, String FLIGHT_STATE, String PRICE, String DATE) {
        this.FLIGHT_NO = FLIGHT_NO;
        this.DEP_CT = DEP_CT;
        this.ARR_CT = ARR_CT;
        this.DEP_SCHEDULED = DEP_SCHEDULED;
        this.ARR_SCHEDULED = ARR_SCHEDULED;
        this.FLIGHT_STATE = FLIGHT_STATE;
        this.PRICE = PRICE;
        this.DATE = DATE;
    }

    public Flight(String FLIGHT_NO, String DEP_CT, String ARR_CT, String DEP_SCHEDULED, String ARR_SCHEDULED, String FLIGHT_STATE, String  PRICE, String DATE, String sendTime) {
        this.FLIGHT_NO = FLIGHT_NO;
        this.DEP_CT = DEP_CT;
        this.ARR_CT = ARR_CT;
        this.DEP_SCHEDULED = DEP_SCHEDULED;
        this.ARR_SCHEDULED = ARR_SCHEDULED;
        this.FLIGHT_STATE = FLIGHT_STATE;
        this.PRICE = PRICE;
        this.DATE = DATE;
        this.sendTime = sendTime;
    }

    public String getFLIGHT_NO() {
        return FLIGHT_NO;
    }

    public void setFLIGHT_NO(String FLIGHT_NO) {
        this.FLIGHT_NO = FLIGHT_NO;
    }

    public String getDEP_CT() {
        return DEP_CT;
    }

    public void setDEP_CT(String DEP_CT) {
        this.DEP_CT = DEP_CT;
    }

    public String getARR_CT() {
        return ARR_CT;
    }

    public void setARR_CT(String ARR_CT) {
        this.ARR_CT = ARR_CT;
    }

    public String getDEP_SCHEDULED() {
        return DEP_SCHEDULED;
    }

    public void setDEP_SCHEDULED(String DEP_SCHEDULED) {
        this.DEP_SCHEDULED = DEP_SCHEDULED;
    }

    public String getARR_SCHEDULED() {
        return ARR_SCHEDULED;
    }

    public void setARR_SCHEDULED(String ARR_SCHEDULED) {
        this.ARR_SCHEDULED = ARR_SCHEDULED;
    }

    public String getFLIGHT_STATE() {
        return FLIGHT_STATE;
    }

    public void setFLIGHT_STATE(String FLIGHT_STATE) {
        this.FLIGHT_STATE = FLIGHT_STATE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }


    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "FLIGHT_NO='" + FLIGHT_NO + '\'' +
                ", DEP_CT='" + DEP_CT + '\'' +
                ", ARR_CT='" + ARR_CT + '\'' +
                ", DEP_SCHEDULED='" + DEP_SCHEDULED + '\'' +
                ", ARR_SCHEDULED='" + ARR_SCHEDULED + '\'' +
                ", FLIGHT_STATE='" + FLIGHT_STATE + '\'' +
                ", PRICE='" + PRICE + '\'' +
                ", DATE='" + DATE + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
