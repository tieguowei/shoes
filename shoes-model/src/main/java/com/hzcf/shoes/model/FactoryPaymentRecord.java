package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.Date;

public class FactoryPaymentRecord {
    private Integer id;

    private String factoryName;

    private Date billStartTime;

    private Date billEndTime;

    private BigDecimal customaryDues;

    private BigDecimal actualPayment;

    private BigDecimal balanceDue;

    private BigDecimal cutPayment;

    private BigDecimal defectiveGoods;

    private String season;

    private String billStatus;

    private Date createTime;

    private Integer operator;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
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

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}