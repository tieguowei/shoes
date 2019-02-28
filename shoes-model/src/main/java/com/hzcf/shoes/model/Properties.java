package com.hzcf.shoes.model;

import java.math.BigDecimal;
import java.util.Date;

public class Properties {
    private Integer id;

    private String propertyName;

    private String propertyStringValue;

    private BigDecimal propertyFigureValue;

    private String propertyDesc;

    private Integer updateUserId;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public String getPropertyStringValue() {
        return propertyStringValue;
    }

    public void setPropertyStringValue(String propertyStringValue) {
        this.propertyStringValue = propertyStringValue == null ? null : propertyStringValue.trim();
    }

    public BigDecimal getPropertyFigureValue() {
        return propertyFigureValue;
    }

    public void setPropertyFigureValue(BigDecimal propertyFigureValue) {
        this.propertyFigureValue = propertyFigureValue;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc == null ? null : propertyDesc.trim();
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}