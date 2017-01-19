package com.pay.comm.basic;


import com.pay.comm.editor.DateEditor;
import com.pay.comm.editor.MyStringTrimmerEditor;
import com.pay.comm.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * Created by abiao on 2016/6/22.
 */
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
//        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new DateEditor(
                DateUtil.dateTimeFormatter, false));
//        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(DateEditor
//                Integer.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(
                Long.class, true));
        binder.registerCustomEditor(String.class, new MyStringTrimmerEditor(true));
    }


}
