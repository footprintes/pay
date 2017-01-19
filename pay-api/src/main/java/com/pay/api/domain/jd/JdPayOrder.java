package com.pay.api.domain.jd;

import javax.persistence.Transient;

/**
 * 商户加密用的基本类
 */
public class JdPayOrder {

    private Long id;
    private String version;
    @Transient
    private String sign;
    private String merchant;
    @Transient
    private String device;
    private String tradeNum;
    private String tradeName;
    private String tradeDesc;
    private String tradeTime;
    private String amount;
    private String currency;
    private String note;
    private String callbackUrl;
    private String notifyUrl;
    private String ip;
    private String specCardNo;
    private String specId;
    private String specName;
    @Transient
    private String userType;
    @Transient
    private String userId;
    @Transient
    private String expireTime;

    private String orderType;
    @Transient
    private String industryCategoryCode;
    @Transient
    private String vendorId;
    @Transient
    private String goodsInfo;
    @Transient
    private String orderGoodsNum;
    @Transient
    private String receiverInfo;
    @Transient
    private String termInfo;
    @Transient
    private String cert;
    @Transient
    private String tradeType;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(String tradeNum) {
        this.tradeNum = tradeNum;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc(String tradeDesc) {
        this.tradeDesc = tradeDesc;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSpecCardNo() {
        return specCardNo;
    }

    public void setSpecCardNo(String specCardNo) {
        this.specCardNo = specCardNo;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIndustryCategoryCode() {
        return industryCategoryCode;
    }

    public void setIndustryCategoryCode(String industryCategoryCode) {
        this.industryCategoryCode = industryCategoryCode;
    }

    /**
     * @return the vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the goodsInfo
     */
    public String getGoodsInfo() {
        return goodsInfo;
    }

    /**
     * @param goodsInfo the goodsInfo to set
     */
    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    /**
     * @return the orderGoodsNum
     */
    public String getOrderGoodsNum() {
        return orderGoodsNum;
    }

    /**
     * @param orderGoodsNum the orderGoodsNum to set
     */
    public void setOrderGoodsNum(String orderGoodsNum) {
        this.orderGoodsNum = orderGoodsNum;
    }

    /**
     * @return the receiverInfo
     */
    public String getReceiverInfo() {
        return receiverInfo;
    }

    /**
     * @param receiverInfo the receiverInfo to set
     */
    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    /**
     * @return the termInfo
     */
    public String getTermInfo() {
        return termInfo;
    }

    /**
     * @param termInfo the termInfo to set
     */
    public void setTermInfo(String termInfo) {
        this.termInfo = termInfo;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    /**
     * @return the tradeType
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType the tradeType to set
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
