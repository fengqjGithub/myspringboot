package com.joy.java.util.lang;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Package: com.hnzr.utils
 * @Class: MyStringUtil
 * @Author: 冯前进
 * @date: 2018/3/4 14:28
 * @Description: TODO
 * @Exception
 **/
public class MyStringUtil extends StringUtils {
    private static Logger log = LoggerFactory.getLogger(MyStringUtil.class);
    /**
     * 实体类对象转换成Map
     * @param obj
     * @return
     */
    public static Map<String, String> ConvertObjToMap(Object obj) {
        Map<String, String> reMap = new HashMap<String, String>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(
                            fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o.toString());
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return reMap;
    }
    public static boolean isBlankMy(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0||"null".equals(cs)) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isNotBlankMy(CharSequence cs) {
        return !isBlankMy(cs);
    }

    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 数组转对象
     * @param bytes
     * @return
     */
    public static Object toObject (byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return obj;
    }
    //图片到byte数组
    public static byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            log.error(ex1.getMessage());
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            log.error(ex1.getMessage());
            ex1.printStackTrace();
        }
        return data;
    }
    //byte数组到图片
    public static boolean byte2image(byte[] data,String path){
        boolean flag=true;
        if(data.length<3||path.equals("")) return false;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        } catch(Exception ex) {
            log.error(ex.getMessage());
            flag=false;
            ex.printStackTrace();
        }
        return flag;
    }
    //byte数组到16进制字符串
    public String byte2string(byte[] data){
        if(data==null||data.length<=1) return "0x";
        if(data.length>200000) return "0x";
        StringBuffer sb = new StringBuffer();
        int buf[] = new int[data.length];
        //byte数组转化成十进制
        for(int k=0;k<data.length;k++){
            buf[k] = data[k]<0?(data[k]+256):(data[k]);
        }
        //十进制转化成十六进制
        for(int k=0;k<buf.length;k++){
            if(buf[k]<16) sb.append("0"+Integer.toHexString(buf[k]));
            else sb.append(Integer.toHexString(buf[k]));
        }
        return "0x"+sb.toString().toUpperCase();
    }

    /**
     * 如果source对象的属性与des对象属性可以匹配，那么source对象属性的值赋值至des对象中
     * @param source
     * @param des
     */
    public void SetSourceToDes(Object source,Object des){
        try{
            //获取源对象类
            Class<? extends Object> sourceSonClass = source.getClass();
//            Class<? extends Object> sourceClass = sourceSonClass.getSuperclass();
            //获取源对象所有的属性
            Field[] sourceFies = sourceSonClass.getDeclaredFields();

            //获取目标对象类
            Class<? extends Object> desClass = des.getClass();
            //获取目标对象所有的属性
            Field[] desFies = desClass.getDeclaredFields();

            if(sourceFies!=null&&sourceFies.length>0&&desFies!=null&&desFies.length>0){
                for (Field sourceFie : sourceFies) {
                    sourceFie.setAccessible(true); //设置些属性是可以访问的
                    for (Field desFie : desFies) {
                        String mod = Modifier.toString(desFie.getModifiers());
                        if(mod.indexOf("static")>=0 || mod.indexOf("final")>=0){
                            continue;
                        }
                        String nameSource = sourceFie.getName().toLowerCase();
                        String nameDes = desFie.getName().toLowerCase();
                        if(sourceFie.getType().getName().equalsIgnoreCase(desFie.getType().getName()) && nameSource.indexOf(nameDes)>=0
                                && nameSource.length()>=nameDes.length()&& nameSource.substring(nameSource.indexOf(nameDes)).equalsIgnoreCase(nameDes)){
                            desFie.setAccessible(true); //设置些属性是可以访问的
                            Object value = sourceFie.get(source);
                            if(value!=null){
                                desFie.set(des, value);
                            }else{
//                                desFie.set(des, "");
                            }
                            break;
                        }
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 如果source父级对象的属性与des对象属性可以匹配，那么source对象属性的值赋值至des对象中
     * @param source
     * @param des
     */
    public void SetSourceParentToDes(Object source,Object des){
        try{
            //获取源对象类
            Class<? extends Object> sourceSonClass = source.getClass();
            Class<? extends Object> sourceClass = sourceSonClass.getSuperclass();
            //获取源对象所有的属性
            Field[] sourceFies = sourceClass.getDeclaredFields();

            //获取目标对象类
            Class<? extends Object> desClass = des.getClass();
            //获取目标对象所有的属性
            Field[] desFies = desClass.getDeclaredFields();

            if(sourceFies!=null&&sourceFies.length>0&&desFies!=null&&desFies.length>0){
                for (Field sourceFie : sourceFies) {
                    sourceFie.setAccessible(true); //设置些属性是可以访问的
                    for (Field desFie : desFies) {
                        String mod = Modifier.toString(desFie.getModifiers());
                        if(mod.indexOf("static")>=0 || mod.indexOf("final")>=0){
                            continue;
                        }
                        String nameSource = sourceFie.getName().toLowerCase();
                        String nameDes = desFie.getName().toLowerCase();
                        if(sourceFie.getType().getName().equalsIgnoreCase(desFie.getType().getName()) && nameSource.indexOf(nameDes)>=0
                                && nameSource.length()>=nameDes.length()&& nameSource.substring(nameSource.indexOf(nameDes)).equalsIgnoreCase(nameDes)){
                            desFie.setAccessible(true); //设置些属性是可以访问的
                            Object value = sourceFie.get(source);
                            if(value!=null){
                                desFie.set(des, value);
                            }else{
//                                desFie.set(des, "");
                            }
                            break;
                        }
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Boolean isEqual(String i, String j) {
        Boolean value = false;
        if (i == null && j == null) {
            value = false;
        } else if (i != null && j != null) {
            if (i.equals(j)) {
                value = true;
            }
        }
        return value;
    }


    /**
     * 去除字串中重复内容
     *
     * @param str septstr
     * @return str
     */
    public static String removeduplication(String str, String septStr) {
        StringBuffer retStr = new StringBuffer("");
        String[] fstr = null;

        if (str!=null && str.length() > 0) {
            fstr = StringUtils.split(str, septStr);
            for (int i=0;fstr!=null&&i<fstr.length;i++) {
                String fstrcut = fstr[i];
                if (fstrcut != null && fstrcut.length() > 0
                        && !"".equals(fstrcut) && retStr.indexOf(fstrcut) == -1) {
                    retStr.append(fstrcut).append(septStr);
                }
            }
        }
        return retStr.toString();
    }


    public static int getStringLength(String src) {
        int length=0;
        if(src==null){
            length=0;
        }
        try {
            String str = new String(src.getBytes("GBK"), "ISO8859_1");
            if(str!=null){
                length=str.length();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            length=0;
        }

        return length;
    }
    /**
     * 首字母转小写
     *
     * @param str
     * @return
     */
    public static String toLowerCaseFirstOne(String str) {
        if (Character.isLowerCase(str.charAt(0)))
            return str;
        else
            return (new StringBuilder()).append(
                    Character.toLowerCase(str.charAt(0))).append(str.substring(1))
                    .toString();
    }

    /**
     * 首字母转大写
     *
     * @param str
     * @return
     */
    public static String toUpperCaseFirstOne(String str) {
        try {
            if (Character.isUpperCase(str.charAt(0))) {
                return str;
            } else {
                return (new StringBuilder()).append(
                        Character.toUpperCase(str.charAt(0))).append(str.substring(1))
                        .toString();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static String splitAndFilterString(String input) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        // 去掉所有html元素,
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        return str;
    }

    /**
     * 去除字段中“_”并且将首字母转大写
     * @param s
     * @return
     */
    public static String toUpperCaseName(String s) {
        String sp[] = s.split("\\_");
        String upperCaseName = "";
        try {
            if (sp.length == 1) {
                upperCaseName = toUpperCaseFirstOne(s.replace("_", ""));
            } else {
                for (int i = 0; i < sp.length; i++) {
                    upperCaseName += toUpperCaseFirstOne(sp[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return upperCaseName;
    }


    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        java.util.regex.Pattern p_html1;
        java.util.regex.Matcher m_html1;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String regEx_html1 = "<[^>]+";
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
            m_html1 = p_html1.matcher(htmlStr);
            htmlStr = m_html1.replaceAll(""); // 过滤html标签

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }

        return textStr;// 返回文本字符串
    }

    public static String toChinese(Integer num) {
        String retStr = "";
        if(num == 1){
            retStr = "一";
        }else if(num == 2){
            retStr = "二";
        }else if(num == 3){
            retStr = "三";
        }else if(num == 4){
            retStr = "四";
        }else if(num == 5){
            retStr = "五";
        }else if(num == 6){
            retStr = "六";
        }else if(num == 7){
            retStr = "七";
        }else if(num == 8){
            retStr = "八";
        }else if(num == 9){
            retStr = "九";
        }else if(num == 10){
            retStr = "十";
        }else if(num == 11){
            retStr = "十一";
        }else if(num == 12){
            retStr = "十二";
        }else if(num == 13){
            retStr = "十三";
        }else if(num == 14){
            retStr = "十四";
        }else if(num == 15){
            retStr = "十五";
        }else if(num == 16){
            retStr = "十六";
        }else if(num == 17){
            retStr = "十七";
        }else if(num == 18){
            retStr = "十八";
        }else if(num == 19){
            retStr = "十九";
        }else if(num == 20){
            retStr = "二十";
        }else if(num == 21){
            retStr = "二十一";
        }else if(num == 22){
            retStr = "二十二";
        }else if(num == 23){
            retStr = "二十三";
        }else if(num == 24){
            retStr = "二十四";
        }else if(num == 25){
            retStr = "二十五";
        }else if(num == 26){
            retStr = "二十六";
        }else if(num == 27){
            retStr = "二十七";
        }else if(num == 28){
            retStr = "二十八";
        }else if(num == 29){
            retStr = "二十九";
        }else if(num == 30){
            retStr = "三十";
        }else if(num == 31){
            retStr = "三十一";
        }

        return retStr;
    }

    public static String getKeyValue(String value, String keyName, String split) {
        String idValue = null;

        if (StringUtils.isNotBlank(value)) {
            if ("|".equals(split)) {
                split = "\\|";
            }
            String[] keyValueArray = value.split(split);
            for (int i = 0; keyValueArray != null && i < keyValueArray.length; i++) {
                if (keyValueArray[i].indexOf(keyName) >= 0) {
                    idValue = keyValueArray[i].substring(keyName.length());
                    continue;
                }
            }
        }
        return idValue;
    }

    /**
     * 默认分割符是: |
     * @param value
     * @param keyName
     * @return
     */
    public static String getKeyValue(String value, String keyName) {
        return getKeyValue(value, keyName, "|");
    }

    /**
     * 把一个以compart分隔的String转成ArrayList
     */
    public static ArrayList<String> stringToArray(String liststr, String compart)
            throws Exception {
        try {
            ArrayList<String> temparray = new ArrayList<String>();
            int pos = 0;
            String tempstr = liststr;
            if (tempstr == null || "".equals(tempstr))
                return null;
            String temp = null;
            while (tempstr.length() > 0) {
                pos = tempstr.indexOf(compart);
                if (pos < 0) {
                    temparray.add(tempstr);
                    break;
                }
                temp = tempstr.substring(0, pos);
                if (temp != null)
                    temparray.add(temp);
                tempstr = tempstr.substring(pos + 1);
            }
            return temparray;
        } catch (Exception e) {
            // e.printStackTrace();
            throw e;
        }
    }
    /**
     * NIO way
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
