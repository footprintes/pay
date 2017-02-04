package com.pay.core.service.sys;

import com.pay.api.domain.sys.SysSerialNumber;
import com.pay.api.service.sys.SysSerialNumberService;
import com.pay.comm.basic.BusinessException;
import com.pay.comm.constant.SysSerialNumberConstant;
import com.pay.comm.util.DateUtil;
import com.pay.core.mapper.writer.sys.SysSerialNumberWriterMapper;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/15 16:40
 */
@MotanService
public class SysSerialNumberServiceImpl implements SysSerialNumberService {

    @Resource
    private SysSerialNumberWriterMapper sysSerialNumberWriterMapper;

    @Resource(name = "writerJdbcTemplate")
    protected JdbcTemplate writerJdbcTemplate;

    /**
     * 生成器锁
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 预生成锁
     */
    private final ReentrantLock prepareLock = new ReentrantLock();

    /**
     * 预生成流水号
     */
    Map<String, List<String>> serialNumberMap = Collections.synchronizedMap(new HashMap<String, List<String>>());

    /**
     * 根据模块code生成预数量的序列号存放到Map中
     *
     * @param sysSerialNumber
     * @param moduleCode      模块code
     * @param preMaxNum       预生成流水号数量
     * @param maxSerial       当前流水号
     * @return
     */
    private List<String> generatePrepareSerialNumbers(SysSerialNumber sysSerialNumber, String moduleCode, Integer preMaxNum, Long maxSerial) {

        //临时List变量
        List<String> resultList = new ArrayList(preMaxNum);
        lock.lock();
        try {
            for (int i = 0; i < preMaxNum; i++) {
                maxSerial = maxSerial + 1;
                if (!isMoreLong(moduleCode, maxSerial)) {
                    //长度超长，重置最大序列号
                    maxSerial = 0l;
                }
                resultList.add(getSerialNumbers(moduleCode, maxSerial));
            }
            sysSerialNumber.setMaxSerial(maxSerial);
            sysSerialNumberWriterMapper.updateByPrimaryKey(sysSerialNumber);
        } finally {
            lock.unlock();
        }
        return resultList;
    }

    /**
     * 根据模块编码生成流水号
     *
     * @param moduleCode
     * @return 流水号
     */
    public String generateSerialNumberByModelCode(String moduleCode) {
        synchronized (moduleCode) {
            //预序列号加锁
            prepareLock.lock();
            try {
                //判断内存中是否还有序列号
                if (null != serialNumberMap.get(moduleCode) && !serialNumberMap.get(moduleCode).isEmpty()) {
                    //若有，返回第一个，并删除
                    return serialNumberMap.get(moduleCode).remove(0);
                }
            } finally {
                //预序列号解锁
                prepareLock.unlock();
            }
            SysSerialNumber sysSerialNumber = new SysSerialNumber();
            sysSerialNumber.setModuleCode(moduleCode);
            sysSerialNumber = sysSerialNumberWriterMapper.selectOne(sysSerialNumber);
            if (sysSerialNumber != null) {
                //预生成流水号数量
                Integer preMaxNum = sysSerialNumber.getPreMaxNum();
                //当前流水号
                Long maxSerial = sysSerialNumber.getMaxSerial();
                //生成预序列号，存到缓存中
                List<String> resultList = generatePrepareSerialNumbers(sysSerialNumber, moduleCode, preMaxNum, maxSerial);
                if (resultList != null && !resultList.isEmpty()) {
                    prepareLock.lock();
                    try {
                        serialNumberMap.put(moduleCode, resultList);
                        return serialNumberMap.get(moduleCode).remove(0);
                    } finally {
                        prepareLock.unlock();
                    }
                }

            } else {
                throw new BusinessException("模块编码不存在，请添加");
            }
        }
        return null;
    }

    /**
     * 检查序列号是否超长
     *
     * @param moduleCode
     * @param maxSerial
     * @return
     */
    public boolean isMoreLong(String moduleCode, Long maxSerial) {
        return (moduleCode + maxSerial).length() <= SysSerialNumberConstant.SYS_SERIAL_MAX_LENGTH;
    }

    /**
     * 获取序列号
     *
     * @param moduleCode
     * @param maxSerial
     * @return
     */
    public String getSerialNumbers(String moduleCode, Long maxSerial) {
        moduleCode = moduleCode + DateUtil.getCurrentDatetime2();
        String serialNumbers = moduleCode + maxSerial;
        if (serialNumbers.length() < SysSerialNumberConstant.SYS_SERIAL_MAX_LENGTH) {
            int diff = SysSerialNumberConstant.SYS_SERIAL_MAX_LENGTH - serialNumbers.length();
            for (int i = 0; i < diff; i++) {
                moduleCode += "0";
            }
            serialNumbers = moduleCode + maxSerial;
        }
        return serialNumbers;
    }

    /**
     * 设置预生成流水号数量
     *
     * @param moduleCode 模块编码
     * @param preMaxNum  预生成数量
     * @return
     */
    public int updatePreMaxNum(String moduleCode, int preMaxNum) {
        return writerJdbcTemplate.update("update sys_serial_number set pre_max_num = " + preMaxNum + " where module_code = '" + moduleCode + "'");
    }
}
