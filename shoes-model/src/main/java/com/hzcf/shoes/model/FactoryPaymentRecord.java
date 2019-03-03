package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.Date;

public class FactoryPaymentRecord {
    private Integer id;

    private String name;

    private Date billStartTime;

    private Date billEndTime;

    private BigDecimal customaryDues;

    private BigDecimal actualPayment;

    private BigDecimal balanceDue;

    private BigDecimal cutPayment;

    private BigDecimal defectiveGoods;

    private String season;

    private Date createTime;

    private Integer operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBillStartTime() {
        return billStartTime;
    }

    public void setBillStartTime(Date billStartTime) {
        this.billStartTime = billStartTime;
    }

    public Date getBillEndTime() {
        return billEndTime;
    }

    public void setBillEndTime(Date billEndTime) {
        this.billEndTime = billEndTime;
    }

    public BigDecimal getCustomaryDues() {
        return customaryDues;
    }

    public void setCustomaryDues(BigDecimal customaryDues) {
        this.customaryDues = customaryDues;
    }

    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public BigDecimal getCutPayment() {
        return cutPayment;
    }

    public void setCutPayment(BigDecimal cutPayment) {
        this.cutPayment = cutPayment;
    }

    public BigDecimal getDefectiveGoods() {
        return defectiveGoods;
    }

    public void setDefectiveGoods(BigDecimal defectiveGoods) {
        this.defectiveGoods = defectiveGoods;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }
}