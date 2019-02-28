package com.hzcf.shoes.model;

public class UserBasicInfo extends Entity{
    private Long basicInfoId;

    private Long loginUserId;

    private String realName;

    private String certiNo;

    private String downImage;

    private String upImage;

    private String recentlyImage;

    private String certiAuditStatus;

    private String failureReason;

    public Long getBasicInfoId() {
        return basicInfoId;
    }

    public void setBasicInfoId(Long basicInfoId) {
        this.basicInfoId = basicInfoId;
    }

    public Long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCertiNo() {
        return certiNo;
    }

    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    public String getDownImage() {
        return downImage;
    }

    public void setDownImage(String downImage) {
        this.downImage = downImage;
    }

    public String getUpImage() {
        return upImage;
    }

    public void setUpImage(String upImage) {
        this.upImage = upImage;
    }

    public String getRecentlyImage() {
        return recentlyImage;
    }

    public void setRecentlyImage(String recentlyImage) {
        this.recentlyImage = recentlyImage;
    }

    public String getCertiAuditStatus() {
        return certiAuditStatus;
    }

    public void setCertiAuditStatus(String certiAuditStatus) {
        this.certiAuditStatus = certiAuditStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}