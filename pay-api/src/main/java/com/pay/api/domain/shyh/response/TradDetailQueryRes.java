package com.pay.api.domain.shyh.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * <p>交易明细查询-响应</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 14:40
 */
public class TradDetailQueryRes extends BaseRes {

    /**
     * 记录总数
     */
    private String recordNum;

    /**
     * 分页页数
     */
    private String pageCount;

    /**
     * 交易明细
     */
    private List<TradDetailInfo> txnInfo;

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public List<TradDetailInfo> getTxnInfo() {
        return txnInfo;
    }

    public void setTxnInfo(List<TradDetailInfo> txnInfo) {
        this.txnInfo = txnInfo;
    }
}
