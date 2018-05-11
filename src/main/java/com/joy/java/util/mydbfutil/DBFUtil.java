package com.joy.java.util.mydbfutil;

import com.joy.java.util.lang.MyStringUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.Character.UnicodeBlock.*;

/**
 * 解析dbf
 *
 * @Project: sfrzapi
 * @Package: com.hnzr.utils.dbf
 * @Author: 冯前进
 * @Date: 2018-02-27 9:10
 * @Description: TODO
 **/
public class DBFUtil {
    /**
     * 按行解析DBF成Map<String,list>
     * map中：
     * dataList为数据
     * column为表头
     * @param file
     * @param memoFile 特殊处理，解析指纹特征的FPT文件，如果不是指纹特征，传null即可
     * @return
     */
    public static Map<String,List> readDBFFile(File file,File memoFile) {
        List dataList = new ArrayList();
        List columnList=new ArrayList();
        Map<String,List> map = new HashMap<>();
        try {
            InputStream inputStream = new FileInputStream(file);
            DBFReader reader = new DBFReader(inputStream,memoFile);
            reader.setCharactersetName("gbk");
            Object[] rowObjects;
            Map row;
            //先获取表头
            int fieldsCount = reader.getFieldCount();
            Map<Integer, String> fieldMap = new HashMap<>();
            for (int i = 0; i < fieldsCount; i++) {
                DBFField field = reader.getField(i);
                //在解析DBF过程中发现部分表头用GBK编码解析会乱码，部分不会乱码，所以特殊处理，将乱码的重新编码
                if (!checkStringContainChinese(field.getName())) {
                    //解决表头中文乱码
                    String title=new String(field.getName().getBytes("ISO8859-1"), "GBK");
                    fieldMap.put(i, title);
                    columnList.add(title);
                } else {
                    fieldMap.put(i, field.getName());
                    columnList.add(field.getName());
                }
            }
            while ((rowObjects = reader.nextRecord()) != null) {
                row = new HashMap();
                for (int i = 0; i < rowObjects.length; i++) {
                    row.put(fieldMap.get(i), rowObjects[i].toString());
                }
                dataList.add(row);
            }
            map.put("dataList",dataList);
            map.put("column",columnList);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DBFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static boolean checkStringContainChinese(String checkStr) {
        if (!MyStringUtil.isEmpty(checkStr)) {
            char[] checkChars = checkStr.toCharArray();
            for (int i = 0; i < checkChars.length; i++) {
                char checkChar = checkChars[i];
                if (checkCharContainChinese(checkChar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCharContainChinese(char checkChar) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(checkChar);
        if (CJK_UNIFIED_IDEOGRAPHS == ub || CJK_COMPATIBILITY_IDEOGRAPHS == ub || CJK_COMPATIBILITY_FORMS == ub ||
                CJK_RADICALS_SUPPLEMENT == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B == ub) {
            return true;
        }
        return false;
    }

    /**
     * 改后3 解决中文乱码
     * @param dbfFlieNameAndLocation
     * @param dataList
     * @param fieldNameList
     * @param fieldList
     * @return
     */
    public static DBFWriter getDBF3Writer(String dbfFlieNameAndLocation, List dataList, List<String> fieldNameList, List<String> fieldList) {
        DBFWriter writer = null;
        try {
            if (dbfFlieNameAndLocation != null) {
                writer = new DBFWriter(new File(dbfFlieNameAndLocation));
            } else {
                writer = new DBFWriter();
            }
            writer.setCharactersetName("GBK");

            int fieldCount = fieldList.size();
            DBFField[] fields = new DBFField[fieldCount];
            Pattern pWord = Pattern.compile("[\u4e00-\u9fa5]");//校验中文的正则表达式

            for (int i = 0; fieldNameList != null && i < fieldNameList.size(); i++) {
                String fieldName = fieldNameList.get(i);
                fieldName = fieldName.length() <= 5 ? fieldName : "col"+ StringUtils.leftPad(String.valueOf(i), 2, "0");
                DBFField field = new DBFField();
                field.setName(fieldName);
                field.setDataType(DBFField.FIELD_TYPE_C);
                field.setFieldLength(128);
                fields[i] = field;
            }
            writer.setFields(fields);

            for (int i = 0; i < dataList.size(); i++) {
                Object obj = dataList.get(i);
                Object[] dowData = new Object[fieldList.size()];
                for (int j = 0; fieldList != null && j < fieldList.size(); j++) {
                    String fieldName = fieldList.get(j);
                    Object object = PropertyUtils.getProperty(obj, fieldName);
                    if(object!=null){
                        String value = object.toString();
                        int m = value.getBytes().length;
                        String blank = "";
                        if (pWord.matcher(value).find()) {// 如果包含中文就要补够2倍中文字数个空格，否则会导致中文乱码
                            for (int k = 0; k < m; k++) {
                                blank += "  ";
                            }
                        }
                        dowData[j] = value+blank;
                    }
                }
                writer.addRecord(dowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer;
    }
}
