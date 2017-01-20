package com.pay.core.service.triple;

import com.pay.api.service.triple.TripleService;
import com.pay.comm.util.TripleDes;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

import java.io.IOException;

/**
 * Created by 王志新 on 2017/1/19
 * User : allycw3
 * Date : 2017/1/19
 * Time : 17:48
 */
@MotanService
public class TripleServiceImpl implements TripleService {

    /**
     * 将文件加密并压缩生成新的文件
     * @param threeDesKey 加密密钥
     * @param inFilePath  要读取的文件路径
     * @param zipFileName 压缩后里面的压缩文件名称
     * @param suffixName 生成的压缩文件后缀名
     * @return
     * @throws Exception
     */
    public boolean makeZipfile(String threeDesKey, String inFilePath, String zipFileName,String suffixName)throws Exception {
        TripleDes.makeZipfile( threeDesKey,  inFilePath,  zipFileName, suffixName);
        return true;
    }

    /**
     * 解压文件并解密
     * @param threeDesKey 解密密钥
     * @param zipFilePath 要解压的文件
     * @param outFilePath 解压后的文件
     * @param suffixName 解压的文件的后缀名
     * @throws Exception
     */
    public boolean makeUnZipfile(String threeDesKey, String zipFilePath, String outFilePath,String suffixName)throws Exception {
        TripleDes.makeUnZipfile( threeDesKey,  zipFilePath,  outFilePath, suffixName);
        return true;
    }
}
