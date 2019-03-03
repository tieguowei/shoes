package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerPaymentRecord {
    private Integer id;

    private String name;

    private Date billStartTime;

    private Date billEndTime;

    private BigDecimal customaryDues;

    private BigDecimal actualPayment;

    private BigDecimal balanceDue;

    private BigDecimal smallChange;

    private BigDecimal defectiveGoods;

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

    public BigDecimal getSmallChange() {
        return smallChange;
    }

    public void setSmallChange(BigDecimal smallChange) {
        this.smallChange = smallChange;
    }

    public BigDecimal getDefectiveGoods() {
        return defectiveGoods;
    }

    public void setDefectiveGoods(BigDecimal defectiveGoods) {
        this.defectiveGoods = defectiveGoods;
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