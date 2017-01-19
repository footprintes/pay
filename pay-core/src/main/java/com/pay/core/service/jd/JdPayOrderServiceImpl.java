package com.pay.core.service.jd;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pay.api.domain.jd.JdPayOrder;
import com.pay.api.service.jd.JdPayOrderService;
import com.pay.core.mapper.writer.jd.JdPayOrderWriterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/12 16:06
 */
@Service
public class JdPayOrderServiceImpl implements JdPayOrderService {

    @Resource
    private JdPayOrderWriterMapper jdPayOrderMapper;

    public int insertSelective(JdPayOrder jdPayOrder) {
        return jdPayOrderMapper.insertSelective(jdPayOrder);
    }

    public List<JdPayOrder> selectAll() {
        return jdPayOrderMapper.selectAll();
    }

//    public List<JdPayOrder> selectPageList(JdPayOrder jdPayOrder) {
//        if (jdPayOrder.getPage() != null && jdPayOrder.getRows() != null) {
//            PageHelper.startPage(jdPayOrder.getPage(), jdPayOrder.getRows(), "id");
//        }
//        return jdPayOrderMapper.selectAll();
//    }

}
