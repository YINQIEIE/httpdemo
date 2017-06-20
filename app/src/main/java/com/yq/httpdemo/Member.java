package com.yq.httpdemo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by yinqi on 2017/6/12.
 */

public class Member implements Serializable {
    protected static final long serialVersionUID = 2742537407237886914L;
    protected int id;
    protected String memberName;
    protected String trueName;
    protected Timestamp lastLoginDate;
    protected String password;
    protected int isUpdatePassword;
    protected int isUpdateName;
    protected String phone;
    protected String mail;
    protected String idcard;
    protected BigDecimal websitePoint;
    protected String terminalId;
    protected Timestamp createTime;
    protected Timestamp closeTime;
    protected Timestamp recoveryTime;
    protected BigDecimal lineMoney;
    protected int popFrom;
    protected int times;
    protected int deviceType;
    protected String deviceToken;

    public Member(String memberName, String terminalId) {
        this.memberName = memberName;
        this.lastLoginDate = new Timestamp(System.currentTimeMillis());
        this.isUpdatePassword = 0;
        this.isUpdateName = 0;
        this.phone = memberName;
        this.websitePoint = new BigDecimal(0);
        if(terminalId != null && !terminalId.equals("")) {
            this.terminalId = terminalId;
        } else {
            this.terminalId = "16003";
        }

        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public Member() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTrueName() {
        return this.trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Timestamp getLastLoginDate() {
        return this.lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLoginPassword() {
        return this.password;
    }

    public void setLoginPassword(String loginPassword) {
        this.password = loginPassword;
    }

    public int getIsUpdatePassword() {
        return this.isUpdatePassword;
    }

    public void setIsUpdatePassword(int isUpdatePassword) {
        this.isUpdatePassword = isUpdatePassword;
    }

    public int getIsUpdateName() {
        return this.isUpdateName;
    }

    public void setIsUpdateName(int isUpdateName) {
        this.isUpdateName = isUpdateName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public BigDecimal getWebsitePoint() {
        return this.websitePoint;
    }

    public void setWebsitePoint(BigDecimal websitePoint) {
        this.websitePoint = websitePoint;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCloseTime() {
        return this.closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Timestamp getRecoveryTime() {
        return this.recoveryTime;
    }

    public void setRecoveryTime(Timestamp recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public BigDecimal getLineMoney() {
        return this.lineMoney;
    }

    public void setLineMoney(BigDecimal lineMoney) {
        this.lineMoney = lineMoney;
    }

    public int getPopFrom() {
        return this.popFrom;
    }

    public void setPopFrom(int popFrom) {
        this.popFrom = popFrom;
    }

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\",\"memberName\":\"" + this.memberName + "\",\"trueName\":\"" + this.trueName + "\",\"lastLoginDate\":\"" + this.lastLoginDate + "\",\"isUpdatePassword\":\"" + this.isUpdatePassword + "\",\"isUpdateName\":\"" + this.isUpdateName + "\",\"phone\":\"" + this.phone + "\",\"mail\":\"" + this.mail + "\",\"idcard\":\"" + this.idcard + "\",\"websitePoint\":\"" + this.websitePoint + "\",\"terminalId\":\"" + this.terminalId + "\",\"createTime\":\"" + this.createTime + "\",\"closeTime\":\"" + this.closeTime + "\",\"recoveryTime\":\"" + this.recoveryTime + "\",\"lineMoney\":\"" + this.lineMoney + "\",\"popFrom\":\"" + this.popFrom + "\",\"times\":\"" + this.times + "\"}  ";
    }
}
