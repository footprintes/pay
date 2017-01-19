package com.pay.api.service.jd;

import com.github.pagehelper.Page;
import com.pay.api.domain.jd.JdPayOrder;

import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/12 15:01
 */
public interface JdPayOrderService {

    int insertSelective(JdPayOrder jdPayOrder);

    List<JdPayOrder> selectAll();

}
