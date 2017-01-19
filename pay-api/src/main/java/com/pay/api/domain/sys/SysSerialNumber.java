package com.pay.api.domain.sys;

import com.pay.api.basic.BaseEntity;

public class SysSerialNumber extends BaseEntity {
    /**
     * 主键 所属表字段为 : sys_serial_number.id
     */
    private Long id;

    /**
     * 模块名称 所属表字段为 : sys_serial_number.module_name
     */
    private String moduleName;

    /**
     * 模块编码 所属表字段为 : sys_serial_number.module_code
     */
    private String moduleCode;

    /**
     * 当前序列号的值 所属表字段为 : sys_serial_number.max_serial
     */
    private Long maxSerial;

    /**
     * 预生成序列号存放到缓存的个数 所属表字段为 : sys_serial_number.pre_max_num
     */
    private Integer preMaxNum;

    /**
     * 获取 主键 字段:sys_serial_number.id
     *
     * @return sys_serial_number.id, 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键 字段:sys_serial_number.id
     *
     * @param id sys_serial_number.id, 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 模块名称 字段:sys_serial_number.module_name
     *
     * @return sys_serial_number.module_name, 模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置 模块名称 字段:sys_serial_number.module_name
     *
     * @param moduleName sys_serial_number.module_name, 模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取 模块编码 字段:sys_serial_number.module_code
     *
     * @return sys_serial_number.module_code, 模块编码
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * 设置 模块编码 字段:sys_serial_number.module_code
     *
     * @param moduleCode sys_serial_number.module_code, 模块编码
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    /**
     * 获取 当前序列号的值 字段:sys_serial_number.max_serial
     *
     * @return sys_serial_number.max_serial, 当前序列号的值
     */
    public Long getMaxSerial() {
        return maxSerial;
    }

    /**
     * 设置 当前序列号的值 字段:sys_serial_number.max_serial
     *
     * @param maxSerial sys_serial_number.max_serial, 当前序列号的值
     */
    public void setMaxSerial(Long maxSerial) {
        this.maxSerial = maxSerial;
    }

    /**
     * 获取 预生成序列号存放到缓存的个数 字段:sys_serial_number.pre_max_num
     *
     * @return sys_serial_number.pre_max_num, 预生成序列号存放到缓存的个数
     */
    public Integer getPreMaxNum() {
        return preMaxNum;
    }

    /**
     * 设置 预生成序列号存放到缓存的个数 字段:sys_serial_number.pre_max_num
     *
     * @param preMaxNum sys_serial_number.pre_max_num, 预生成序列号存放到缓存的个数
     */
    public void setPreMaxNum(Integer preMaxNum) {
        this.preMaxNum = preMaxNum;
    }
}