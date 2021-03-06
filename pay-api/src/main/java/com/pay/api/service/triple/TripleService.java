package com.pay.api.service.triple;

import java.io.IOException;

/**
 * Created by 王志新 on 2017/1/19
 * User : allycw3
 * Date : 2017/1/19
 * Time : 17:49
 */
public interface TripleService {

    /**
     * 将文件加密并压缩生成新的文件
     * @param threeDesKey 加密密钥
     * @param inFilePath  要读取的文件路径
     * @param zipFileName 压缩后里面的压缩文件名称
     * @param suffixName 生成的压缩文件后缀名
     * @return
     * @throws Exception
     */
    boolean makeZipfile(String threeDesKey, String inFilePath, String zipFileName,String suffixName)throws Exception;

    /**
     * 解压文件并解密
     * @param threeDesKey 解密密钥
     * @param zipFilePath 要解压的文件
     * @param outFilePath 解压后的文件
     * @param suffixName 解压的文件的后缀名
     * @throws Exception
     */
    boolean makeUnZipfile(String threeDesKey, String zipFilePath, String outFilePath,String suffixName)throws Exception;
}
