package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerPaymentRecord {
    private Integer id;

    private String customerName;

    private Date billStartTime;

    private Date billEndTime;

    private BigDecimal customaryDues;

    private BigDecimal actualPayment;

    private BigDecimal balanceDue;

    private BigDecimal smallChange;

    private BigDecimal defectiveGoods;

    private BigDecimal spredReturnMoney;

    private String billStatus;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Integer operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
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

    public BigDecimal getSpredReturnMoney() {
        return spredReturnMoney;
    }

    public void setSpredReturnMoney(BigDecimal spredReturnMoney) {
        this.spredReturnMoney = spredReturnMoney;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }
}