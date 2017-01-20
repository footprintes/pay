package com.pay.comm.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 王志新 on 2017/1/19
 * User : allycw3
 * Date : 2017/1/19
 * Time : 17:27
 */
public class TripleDesTool {


    private static final String ALGORITHM = "DESede";

//	private static final String ALGORITHM = "DESede/ECB/PKCS5Padding";

//    private static final Logger log = Logger.getLogger(TripleDesTool.class);
    private static final Logger log = LoggerFactory.getLogger(TripleDesTool.class);

    //定义 加密算法,可用 DES,DESede,Blowfish
    //keybyte为加密密钥，长度为24字节
    //src为被加密的数据缓冲区（源）

    /**
     * 设置数据流为加密模式
     * @param secretKey
     * @param outputStream
     * @return
     */
    public static CipherOutputStream encryptMode(SecretKey secretKey, OutputStream outputStream) {
        try {
            //加密
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.ENCRYPT_MODE, secretKey);
            return new CipherOutputStream(outputStream, c1);

        } catch (java.lang.Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * 设置数据流为加密模式
     * @param des3Key
     * @param outputStream
     * @return
     */
    public static CipherOutputStream encryptMode(String des3Key, OutputStream outputStream) {
        //生成密钥
        SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM);
        return encryptMode(secretKey, outputStream);

    }

    /**
     * 设置数据流为解密模式
     * @param des3Key
     * @param inputStream
     * @return
     */
    public static CipherInputStream decryptMode(String des3Key, InputStream inputStream) {
        //生成密钥
        SecretKey deskey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM); //解密
        return decryptMode(deskey, inputStream);
    }

    /**
     * 设置数据流为解密模式
     * @param secretKey
     * @param inputStream
     * @return
     */
    public static CipherInputStream decryptMode(SecretKey secretKey, InputStream inputStream) {
        try {
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.DECRYPT_MODE, secretKey);
            return new CipherInputStream(inputStream, c1);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
//    	String des3Key = "123456781234567812345678";
//    	String str = "DESede/CBC/PKCS5Padding";
//    	String str1 = "DESede";
//    	String str2 = "DESede/CBC/NoPadding";
//    	String str3 = "DESede/CBC/PKCS5Padding";
//    	String str4 = "DESede/ECB/NoPadding";
//    	String str5 = "DESede/ECB/PKCS5Padding";
//    	SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), str1);
////    	Cipher c1 = Cipher.getInstance(str1);
////    	//解密
////    	c1.init(Cipher.DECRYPT_MODE, secretKey);
//
//    	//加密
//    	String miwen = "asdfghjk";
//    	Cipher c2 = Cipher.getInstance(str1);
//    	c2.init(Cipher.ENCRYPT_MODE, secretKey);
//    	byte[] data = c2.doFinal(miwen.getBytes());
//    	System.out.println("加密后：/t"+Base64.encodeBase64String(data));
//
//
//    	//-----
//    	String KEY_ALGORITHM = "DESede";
//    	String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";
////    	String CIPHER_ALGORITHM = "DESede/CBC/PKCS5Padding";
//    	//实例化Des密钥
//        DESedeKeySpec dks=new DESedeKeySpec(des3Key.getBytes());
//        //实例化密钥工厂
//        SecretKeyFactory keyFactory=SecretKeyFactory.getInstance(KEY_ALGORITHM);
//        //生成密钥
//        SecretKey secretKey1=keyFactory.generateSecret(dks);
//        //实例化
//        Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
//        //初始化，设置为加密模式
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey1);
//        byte[] data1 = cipher.doFinal(miwen.getBytes());
//        System.out.println("加密后：/t"+Base64.encodeBase64String(data1));
    }
}
