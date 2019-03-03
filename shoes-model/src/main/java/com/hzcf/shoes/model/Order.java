package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Date payTime;

    private String customerName;

    private String factoryName;

    private String itemNo;

    private Integer numberPackages;

    private Integer shoeDual;

    private BigDecimal salePrice;

    private BigDecimal priceSpread;

    private Integer differenceNumber;

    private Integer returnsNumber;

    private String customerIsDefectiveGoods;

    private String factoryIsDefectiveGoods;

    private String season;

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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    public Integer getNumberPackages() {
        return numberPackages;
    }

    public void setNumberPackages(Integer numberPackages) {
        this.numberPackages = numberPackages;
    }

    public Integer getShoeDual() {
        return shoeDual;
    }

    public void setShoeDual(Integer shoeDual) {
        this.shoeDual = shoeDual;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getPriceSpread() {
        return priceSpread;
    }

    public void setPriceSpread(BigDecimal priceSpread) {
        this.priceSpread = priceSpread;
    }

    public Integer getDifferenceNumber() {
        return differenceNumber;
    }

    public void setDifferenceNumber(Integer differenceNumber) {
        this.differenceNumber = differenceNumber;
    }

    public Integer getReturnsNumber() {
        return returnsNumber;
    }

    public void setReturnsNumber(Integer returnsNumber) {
        this.returnsNumber = returnsNumber;
    }

    public String getCustomerIsDefectiveGoods() {
        return customerIsDefectiveGoods;
    }

    public void setCustomerIsDefectiveGoods(String customerIsDefectiveGoods) {
        this.customerIsDefectiveGoods = customerIsDefectiveGoods == null ? null : customerIsDefectiveGoods.trim();
    }

    public String getFactoryIsDefectiveGoods() {
        return factoryIsDefectiveGoods;
    }

    public void setFactoryIsDefectiveGoods(String factoryIsDefectiveGoods) {
        this.factoryIsDefectiveGoods = factoryIsDefectiveGoods == null ? null : factoryIsDefectiveGoods.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
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