package com.joy.java.util;

import com.joy.java.util.io.TextUtil;
import com.joy.java.util.io.ZipUtil;
import com.joy.java.util.lang.MyStringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.util
 * @Author: Joy
 * @Date: 2018-05-07 10:25
 * @Description: TODO
 **/
public class DecryptDatFile {
    public static void main(String[] args) {

        List<String> fileList = ZipUtil.getFileListByType("E:\\项目资料\\bats", new ArrayList<String>(), "attlog.dat");
//        String url="E:\\项目资料\\淇滨小学考点指纹仪原始数据\\log_7913933221945\\20171224162600_7913933221945_attlog.dat";
        for(String url: fileList){
            DecryptMyfile(url);
        }
    }

    public static String DecryptMyfile(String fileUrl) {
        String cfile = "";//解压后的文件名
        cfile = fileUrl.replace("dat", "txt").replace("bats","txt");
        if(!new File(cfile).exists()){
            new File(cfile.substring(0,cfile.lastIndexOf("\\"))).mkdirs();
        }
        byte[] byDataBuf = new byte[10000];
        int iLength = 0;
        try {
            byDataBuf = MyStringUtil.toByteArray2(fileUrl);
            FileInputStream fs = new FileInputStream(fileUrl);
//            iLength = fs.read();
            iLength=(int) new File(fileUrl).length();
            byte[] RealLog = new byte[iLength + 1];
            //解密
            int i, h, l, m, n, j = 0;
            for (i = 0; i < iLength; i = i + 2) {
                h = (byDataBuf[i] - 'x');
                l = (byDataBuf[i + 1] - 'z');
                m = (h << 4);
                n = (l & 0xf);
                RealLog[j] = Byte.parseByte(String.valueOf(m + n));
                j++;
            }
            RealLog[j] = Byte.parseByte("0");
            String result = new String(RealLog);
            TextUtil.wirte(cfile, result);
            System.out.println("---------"+result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
