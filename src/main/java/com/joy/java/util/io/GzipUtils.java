package com.joy.java.util.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * gzip压缩
 * Created by jing on 6/30/16.
 */
public class GzipUtils {
    private static Logger logger = LoggerFactory.getLogger(GzipUtils.class);
    /**
     * gzip压缩
     * @param str
     * @return
     */
    public static byte[] compressToByte(byte[] str) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str);
            gzip.finish();
            //gzip.flush();
            gzip.close();
        } catch (IOException e) {
            logger.error(e.getStackTrace()[0].getMethodName(), e);
            gzip=null;
        }
        return out.toByteArray();
    }

    /**
     *
     * 转换压缩流为普通流
     * @param in
     * @return
     */
    public static byte[] uncompressToStringback(InputStream in) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            GZIPInputStream gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toByteArray();
        } catch (IOException e) {
            logger.error(e.getStackTrace()[0].getMethodName(), e);
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                in=null;
                out=null;
                logger.error(e.getStackTrace()[0].getMethodName(), e);
            }

        }
        return null;
    }
    /**
     *
     * gzip解压
     * @param b
     * @return
     */
    public static byte[] uncompressToStringback(byte[] b) {
        if (b == null || b.length == 0) {
            return null;
        }
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        return uncompressToStringback(in);
    }
}
