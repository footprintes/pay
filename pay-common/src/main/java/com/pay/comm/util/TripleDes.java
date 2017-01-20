package com.pay.comm.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.*;

/**
 * Created by 王志新 on 2017/1/19
 * User : allycw3
 * Date : 2017/1/19
 * Time : 17:25
 */
public class TripleDes {


    private static int BUFFER_SIZE = 1024*1024;


    private static final Logger log = LoggerFactory.getLogger(TripleDes.class);

//    /**
//     * 解压文件
//     * @param fileAllNameZip 被解压文件全路径
//     *        fileAllNameTxt 解压好的文件放置全路径
//     * @return
//     * @throws IOException
//     */
//    public static File decodeCCFFile(String fileAllNameZip, String fileAllNameTxt) throws IOException {
//
//        //解压完的文件
//        File file = new File(fileAllNameTxt);
//        if(!file.exists()){
//            File fileParent = new File(file.getParent());
//            if(!fileParent.isDirectory()){
//                fileParent.mkdirs();
//            }
//            file.createNewFile();
//        }
//
//        ZipFile zFile = new ZipFile(fileAllNameZip);
//        ZipEntry zEntry=zFile.entries().nextElement();
//        CRLFLineReader reader = new CRLFLineReader(new InputStreamReader(zFile.getInputStream(zEntry)));
//        BufferedWriter writer=new BufferedWriter(new FileWriter(file));
//        String line=reader.readLine();
//        while(line!=null){
//            writer.write(line);
//            line=reader.readLine();
//        }
//        reader.close();
//        writer.close();
//        return file;
//
//    }
//
//
//
    /**
     * 压缩文件
     * @param fileAllNameTxt 需要压缩的文件全路径
     *        fileAllNameZip 压缩好的文件的全路径
     * @return
     * @throws IOException
     */
    public static File condenseFile(String threeDesKey, String fileAllNameTxt,String fileAllNameZip) throws Exception {


        File file = new File(fileAllNameTxt);
        File zFile = new File(fileAllNameZip);

        if (!file.exists()) {
            throw new Exception("文件不存在");
        } else {
            if (!zFile.exists()) {
                zFile.createNewFile();
            }
            // 创建文件输入流对象
            FileInputStream in = new FileInputStream(file);
            // 创建文件输出流对象
            FileOutputStream out = new FileOutputStream(zFile);

            int number = 0;
            byte[] buffer = new byte[512];
            while ((number = in.read(buffer)) != -1) {
                out.write(buffer, 0, number);
            }
            out.close();
            in.close();

            OutputStream encryptOutPutStream = TripleDesTool.encryptMode(threeDesKey, out);
            // 设置流以压缩模式输出
            ZipOutputStream zipOutPutStream = new ZipOutputStream(encryptOutPutStream);
            zipOutPutStream.putNextEntry(new ZipEntry(file.getName()));
//            // 创建ZIP数据输出流对象
//            ZipOutputStream zipOut = new ZipOutputStream(out);
//            // 创建指向压缩原始文件的入口
////            ZipEntry entry = new ZipEntry(StringUtils.substring(file.getName(), 0, file.getName().length()-4));
//            ZipEntry entry = new ZipEntry(file.getName().substring( 0, file.getName().length()-4));
//            zipOut.putNextEntry(entry);
//            // 向压缩文件中输出数据
//            int number = 0;
//            byte[] buffer = new byte[512];
//            while ((number = in.read(buffer)) != -1) {
//                zipOut.write(buffer, 0, number);
//            }
//            zipOut.close();
//            out.close();
//            in.close();
        }
        return zFile;
    }
//
//    /**
//     * 解压zip文件（光大）
//     * yangyulong
//     * @param srcfile  原zip压缩文件
//     * @param destFile  解压成的文件
//     * @param destCharest 解压成的文件编码
//     * @throws Exception
//     */
//    public static void makeGDUnZipFile(File srcfile,File destFile,String destCharest) throws Exception{
//        ZipFile zFile = new ZipFile(srcfile);
//        ZipEntry zEntry = zFile.entries().nextElement();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(zFile.getInputStream(zEntry)));
//        BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile),destCharest));
//        String line=reader.readLine();
//        while (line!=null) {
//            writer.write(line);
//            writer.newLine();
//            line=reader.readLine();
//        }
//        zFile.close();
//        reader.close();
//        writer.close();
//    }
//
//    /**压缩文件（光大）
//     * yangyulong
//     * @param srcfile  原文件
//     * @param destFile  压缩文件
//     * @param srcCharest 原文件的编码
//     * @throws Exception
//     */
//    public static void makeGDZipFile(File srcfile,File destFile,String srcCharest) throws Exception{
//        // 创建文件输入流对象
//        FileInputStream in = new FileInputStream(srcfile);
//        // 创建文件输出流对象
//        FileOutputStream out = new FileOutputStream(destFile);
//        // 创建ZIP数据输出流对象
//        ZipOutputStream zipOut = new ZipOutputStream(out);
//        // 创建指向压缩原始文件的入口
//        ZipEntry entry = new ZipEntry(srcfile.getName());
//        zipOut.putNextEntry(entry);
//        // 向压缩文件中输出数据
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in,srcCharest));
//        String line=reader.readLine();
//        while (line!=null) {
//            zipOut.write((line+java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("line.separator"))).getBytes());
//            line=reader.readLine();
//        }
//        zipOut.close();
//        reader.close();
//    }
//
//
//	public static void initKey() throws IOException {
//		//threeDesKey = PropertyUtil.getProperty("threeDesKey");
//	}
//
    /**
     * 将文件加密后压缩
     *
     * @param threeDesKey 加密密钥
     * @param inFilePath 要读取的文件路径
     * @param zipFileName 压缩后里面的压缩文件名称
     * @param suffixName 生成的压缩文件后缀名
     * @throws IOException
     */
    public static void makeZipfile(String threeDesKey, String inFilePath, String zipFileName,String suffixName) throws Exception {
        log.info("将文件：{}加密后并压缩开始", inFilePath);
        if("zip".equals(suffixName)){
            entryFile( threeDesKey, inFilePath, inFilePath+"_temp");
            zipFile( inFilePath+"_temp", inFilePath+"."+suffixName, zipFileName);
        }
        deleteFile(inFilePath+"_temp");
        log.info("将文件：{}加密后并压缩完成", inFilePath);
    }

    /**
     * 删除文件
     * @param delFilePath 要删除的文件路径
     * @throws Exception
     */
    public static void deleteFile(String delFilePath) throws Exception{
        File file = new File(delFilePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }
    /**
     * 将文件加密(传递路径)
     * @param threeDesKey 加密密钥
     * @param inFilePath 要读取的文件路径
     * @param outFilePath 要输出的文件路径(如果不存此文件,则新建此文件)
     * @throws Exception
     */
    public static void entryFile(String threeDesKey,String inFilePath,String outFilePath)throws Exception{
        //要读取的文件
        File file = new File(inFilePath);
        //要输出的文件
        File zFile = new File(outFilePath);
        if (!zFile.exists()) {
            zFile.createNewFile();
        }
        entryFile(threeDesKey,file,zFile);
    }

    /**
     * 将文件加密(传递文件)
     * @param threeDesKey 加密密钥
     * @param inFile 要读取的文件
     * @param outFile 要输出的文件(如果不存此文件,则新建此文件)
     * @throws Exception
     */
    public static void entryFile(String threeDesKey,File inFile,File outFile)throws Exception{
        //要读取的文件
        FileInputStream fis = new FileInputStream(inFile);

        //要输出的文件
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(outFile);
        //加密
        OutputStream encryptOutPutStream = TripleDesTool.encryptMode(threeDesKey, fos);

        int number = 0;
        byte[] buffer = new byte[512];
        while ((number = fis.read(buffer)) != -1) {
            encryptOutPutStream.write(buffer, 0, number);
        }
        encryptOutPutStream.close();
        fos.close();
        fis.close();
    }

    /**
     * 压缩文件(传递路径)
     * @param inFilePath 要读取的文件路径
     * @param outFilePath 要输出的文件路径,如果此文件不存在,则新建一个文件
     * @param zipFileName 压缩后里面的压缩文件名称
     * @throws Exception
     */
    public static void zipFile(String inFilePath,String outFilePath,String zipFileName)throws Exception{
        //要读取的文件
        File inFile = new File(inFilePath);
        File outFile = new File(outFilePath);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        zipFile( inFile, outFile, zipFileName);
    }

    /**
     * 压缩文件(传递文件)
     * @param inFile 要读取的文件
     * @param outFile 要输出的文件,如果此文件不存在,则新建一个文件
     * @param zipFileName 压缩后里面的压缩文件名称
     * @throws Exception
     */
    public static void zipFile(File inFile,File outFile,String zipFileName)throws Exception{
        //要读取的文件
        FileInputStream inFis = new FileInputStream(inFile);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        //要输出的文件
        FileOutputStream outFos = new FileOutputStream(outFile);
        ZipOutputStream zipOutPutStream = new ZipOutputStream(outFos);
        zipOutPutStream.putNextEntry(new ZipEntry(zipFileName));
        int number = 0;
        byte[] buffer = new byte[512];
        while ((number = inFis.read(buffer)) != -1) {
            zipOutPutStream.write(buffer, 0, number);
        }
        zipOutPutStream.close();
        outFos.close();
        inFis.close();
    }

//    private static OutputStream alipayUploadOuputStream(String threeDesKey, OutputStream fileOuputStream, String zipEntryName)
//            throws IOException {
//        // 设置流以加密模式输出
//        OutputStream encryptOutPutStream = TripleDesTool.encryptMode(threeDesKey, fileOuputStream);
//        // 设置流以压缩模式输出
//        ZipOutputStream zipOutPutStream = new ZipOutputStream(encryptOutPutStream);
//        zipOutPutStream.putNextEntry(new ZipEntry(zipEntryName));
//        return zipOutPutStream;
//
//    }
//
//    public static TarArchiveOutputStream alipay1UploadOuputStream(String threeDesKey, OutputStream fileOuputStream)
//            throws IOException {
//        // 设置流以加密模式输出
//        OutputStream encryptOutPutStream = TripleDesTool.encryptMode(threeDesKey, fileOuputStream);
//        // 设置流为gz
//        TarArchiveOutputStream taOut = new TarArchiveOutputStream(
//                new GZIPOutputStream(new BufferedOutputStream(encryptOutPutStream)));
//        return taOut;
//
//    }
//
//    /**
//     * 生成一个40位16进制的摘要字符串(SHA-1算法)
//     */
//    public static String fileDigester(String zipFileLoad) throws Exception {
//
//        String digest = "";
//        FileInputStream in = null;
//        try {
//            in = new FileInputStream(zipFileLoad);
//            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//            IOUtils.copy(in, byteStream);
//            digest = digest(byteStream.toByteArray());
//        } catch (FileNotFoundException e) {
//            log.error(e.getMessage());
//            throw new Exception("文件摘要生成失败");
//        } catch (IOException e) {
//            log.error(e.getMessage());
//            throw new Exception("文件摘要生成失败");
//        } catch (NoSuchAlgorithmException e) {
//            log.error(e.getMessage());
//            throw new Exception("文件摘要生成失败");
//        } finally {
//            try {
//                if(in!=null){
//                    in.close();
//                }
//            } catch (IOException e) {
//                log.error(e.getMessage());
//            }
//        }
//        return digest;
//    }
//
//    /**
//     * 计算文件摘要
//     *
//     * @param contents
//     * @return
//     * @throws NoSuchAlgorithmException
//     */
//    public static String digest(byte[] contents) throws NoSuchAlgorithmException {
//
//        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
//
//        messageDigest.update(contents);
//
//        return bytes2Hex(messageDigest.digest()).toUpperCase();
//
//    }
//
//    /**
//     * 转换为40位16进制字符串
//     *
//     * @param bts
//     * @return
//     */
//    public static String bytes2Hex(byte[] bts) {
//        String des = "";
//        String tmp = null;
//        for (int i = 0; i < bts.length; i++) {
//            tmp = (Integer.toHexString(bts[i] & 0xFF));
//            if (tmp.length() == 1) {
//                des += "0";
//            }
//            des += tmp;
//        }
//        return des;
//    }
//
    /**
     * 该方法对一个加密的Zip文件进行解密输出。
     *
     * @param threeDesKey
     * @throws Exception
     * @throws FileNotFoundException
     */
//    public static File makeUnZipfile(String threeDesKey, String fileAllNameZip, String fileAllNameTxt) throws IOException {
//        log.info("将文件：{}解密到：{}，开始", fileAllNameZip,fileAllNameTxt);
//        // 对一个加密的Zip文件进行解密输出。
//        InputStream in = null;
//        FileOutputStream fos = null;
//        FileInputStream fis = null;
//        try {
//            //threeDesKey = null == threeDesKey || "".equals(threeDesKey.trim()) ? PropertyUtil.getProperty("threeDesKey") : threeDesKey;
//            fis = new FileInputStream(fileAllNameZip);
//            in = alipayDownloadInputStream(threeDesKey, fis);
//            fos = new FileOutputStream(new File(fileAllNameTxt));
//            IOUtils.copy(in, fos);
//
//        } catch (FileNotFoundException e) {
//            log.error("文件解密解压失败,文件路径：" + fileAllNameZip + "解密路径：" + fileAllNameTxt);
//            log.error("文件解密解压失败", e);
//            throw e;
//        } catch (IOException e) {
//            log.error("文件解密解压失败,文件路径：" + fileAllNameZip + "解密路径：" + fileAllNameTxt);
//            log.error("文件解密解压失败", e);
//            throw e;
//        } catch (Exception e) {
//            log.error("文件解密解压失败", e);
//            throw new IOException();
//        }finally {
//            try {
//                if (null != fos) {
//                    fos.close();
//                }
//                if (null != in) {
//                    in.close();
//                }
//                if (null != fis) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                log.error("文件解密失败，关闭流失败");
//                throw e;
//            }
//        }
//        log.info("将文件：{}解密到：{}，完成", fileAllNameZip,fileAllNameTxt);
//        return new File(fileAllNameTxt);
//    }

    public static File makeUnZipfile(String threeDesKey, String fileAllNameZip, String fileAllNameTxt) throws IOException {
        log.info("将文件：{}解密到：{}，开始", fileAllNameZip,fileAllNameTxt);
        // 对一个加密的Zip文件进行解密输出。
        InputStream in = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //threeDesKey = null == threeDesKey || "".equals(threeDesKey.trim()) ? PropertyUtil.getProperty("threeDesKey") : threeDesKey;
            fis = new FileInputStream(fileAllNameZip);
            in = alipayDownloadInputStream(threeDesKey, fis);
            fos = new FileOutputStream(new File(fileAllNameTxt));
            IOUtils.copy(in, fos);

        } catch (FileNotFoundException e) {
            log.error("文件解密解压失败,文件路径：" + fileAllNameZip + "解密路径：" + fileAllNameTxt);
            log.error("文件解密解压失败", e);
            throw e;
        } catch (IOException e) {
            log.error("文件解密解压失败,文件路径：" + fileAllNameZip + "解密路径：" + fileAllNameTxt);
            log.error("文件解密解压失败", e);
            throw e;
        } catch (Exception e) {
            log.error("文件解密解压失败", e);
            throw new IOException();
        }finally {
            try {
                if (null != fos) {
                    fos.close();
                }
                if (null != in) {
                    in.close();
                }
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                log.error("文件解密失败，关闭流失败");
                throw e;
            }
        }
        log.info("将文件：{}解密到：{}，完成", fileAllNameZip,fileAllNameTxt);
        return new File(fileAllNameTxt);
    }

    private static InputStream alipayDownloadInputStream(String threeDesKey, InputStream fileInputStream) throws IOException {
        InputStream decryptInputStream = TripleDesTool.decryptMode(threeDesKey, fileInputStream);
        // 设置流以解密模式输出
        ZipInputStream zipIn = new ZipInputStream(decryptInputStream);
        if (zipIn.getNextEntry() == null) {
            return null;
        }
        return zipIn;
    }
//
//    /**
//     * 处理tar.gz文件解密输出
//     * @param threeDesKey
//     * @param fileInputStream
//     * @return
//     * @throws IOException
//     */
//    private static GzipCompressorInputStream alipay1DownloadInputStream(String threeDesKey, InputStream fileInputStream) throws IOException {
//        InputStream decryptInputStream = TripleDesTool.decryptMode(threeDesKey, fileInputStream);
//        // 设置流以解密模式输出
//        GzipCompressorInputStream gzIn = new GzipCompressorInputStream(decryptInputStream);
//
//        return gzIn;
//    }
//
//    public static String getDecodeFullpath(String filename) {
//        String path = getDecodeFullDir(filename) + filename;
//        path = path.replace("zip", "txt");
//        return path;
//    }
//
//    public static String getDecodeFullDir(String filename) {
//        String dateInfo = filename.substring(filename.indexOf("_") + 1, filename.indexOf("_") + 9);
//        String path = "";
//        try {
////			path = PropertyUtil.getProperty("ccfDecodePath");
//            path="";
//        } catch (Exception e) {
//
//        }
//        // path = "D:\\ca1\\";
//        path += dateInfo.substring(0, 4) + File.separator + dateInfo.substring(4, 6) + File.separator;
//        return path;
//    }
//
//    /**
//     * 该方法对一个.tar.gz文件进行解密输出
//     *
//     * @param threeDesKey
//     * @param fileAllNameZip
//     * @param fileAllNameTxt
//     * @return
//     * @throws Exception
//     */
//    public static File makeUnTarGzfile(String threeDesKey, String fileAllNameTarGz, String fileAllNameTar,String fileAllNameTxt) throws Exception {
//        log.info("将文件：{}解密到：{}，开始", fileAllNameTarGz,fileAllNameTxt);
//        // 对一个加密的.tar.gz文件进行解密输出。
//        GzipCompressorInputStream gzIn = null;
//
//        File tarFile = new File(fileAllNameTar);
//        //tar文件输出流
//        FileOutputStream tarFos = new FileOutputStream(tarFile);
//        //.tar.gz文件输出流
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(fileAllNameTarGz);
//            gzIn = alipay1DownloadInputStream(threeDesKey, fis);
//            final byte[] buffer = new byte[BUFFER_SIZE];
//            int n = 0;
//            while (-1 != (n = gzIn.read(buffer))) {
//                tarFos.write(buffer, 0, n);
//            }
//            tarFos.close();
//            gzIn.close();
//            //解tar包
//            TarUtils.dearchive(tarFile);
//        } catch (Exception e) {
//            log.error("文件解密解压失败,文件路径：" + fileAllNameTarGz + "解密路径：" + fileAllNameTxt);
//            log.error("文件解密解压失败", e);
//            throw e;
//        }finally{
//            try {
//                if(gzIn != null){
//                    gzIn.close();
//                }
//                if(tarFos != null){
//                    tarFos.close();
//                }
//                if(fis != null){
//                    fis.close();
//                }
//            } catch (Exception e2) {
//                log.error("文件解密失败，关闭流失败");
//                throw e2;
//            }
//        }
//
//        log.info("将文件：{}解密到：{}，成功", fileAllNameTarGz,fileAllNameTxt);
//
//        return null;
//    }
//
//	/**
//	 * 将文件压缩成tar.gz并加密
//	 * @param fileAllNameZip
//	 * @param fileName
//	 * @param fileAllName
//	 * @return
//	 * @throws Exception
//	 */
//	public static File makeTarGzfile(String fileAllNameZip, String fileName, String fileAllName) throws Exception {
//		log.info("将文件：{}加密到：{}，开始", fileAllName,fileAllNameZip + File.separator + fileName);
//		// 将生成文件达成tar包
//		File srcFile = new File(fileAllName);
//		TarUtils.archive1(srcFile);
//
//		String basePath = srcFile.getParent();
//		String destPath = basePath + ".tar";
//		File tarFile = new File(destPath);
//		FileOutputStream tarOut = new FileOutputStream(tarFile);
//		OutputStream out = alipay1UploadOuputStream(threeDesKey,tarOut);
//
//		FileInputStream fis = new FileInputStream(destPath+".gz");
//		IOUtils.copy(fis, out);
//        return null;
//	}

    public static void main(String[] args) throws Exception {
//		makeZipfile("D:\\fan\\test\\B_CBIB0017_NJQ_20151009_001","11","D:\\fan\\test\\B_CBIB0017_NJQ_20151009_001");
//		makeUnZipfile("D:\\fan\\test\\B_CBIB0017_NJQ_20151009_001","D:\\fan\\test\\B_CBIB0017_NJQ_20151009_003");
//		makeTarGzfile("E:\\1\\JD_20160509_01\\JD.LOAN.TOTAL.txt","JD_20160509_01","E:\\1\\JD_20160509_01\\JD.LOAN.TOTAL.txt");
//		makeUnTarGzfile("E:\\1\\JD2016092301.tar.gz","E:\\1\\JD2016092301.tar","JD.LOAN.TOTAL.txt");
//		File tarFile = new File("E:\\1\\JD2016060601.tar");
//		TarUtils.dearchive(tarFile);
//		File srcFile = new File("E:\\1\\JD_20160509_01\\JD.LOAN.TOTAL.txt");
//		TarUtils.archive1(srcFile);
//		File file = new File("D:\\fan\\1");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.getPath());
//		File fileDes = TripleDes.makeUnZipfile(file.getAbsolutePath(), file.getAbsolutePath()+"des");

    }
}
