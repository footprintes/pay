package com.xtr.api.service.sys;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/15 16:36
 */
public interface SysSerialNumberService {

    /**
     * 根据模块编码生成流水号
     *
     * @param moduleCode
     * @return 流水号
     */
    String generateSerialNumberByModelCode(String moduleCode);

    /**
     * 设置预生成流水号数量
     *
     * @param preMaxNum 预生成数量
     * @return
     */
    int updatePreMaxNum(String moduleCode, int preMaxNum);

}
