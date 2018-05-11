package com.joy.java.util.mydbfutil.test;

import com.joy.java.util.mydbfutil.DBFUtil;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.kqzb.importBaseInfo
 * @Author: 冯前进
 * @Date: 2018-02-27 11:47
 * @Description: TODO
 **/
public class ImportBaseDataController {
    /**
     * DBFFilePath "DBF文件路径",
     * FPTFilePath "FPT文件路径"
     *
     * @param DBFFilePath
     * @param FPTFilePath
     * @return
     */
    public Map<String, String> importBaseData(String DBFFilePath,String FPTFilePath) {
        Date startDate = new Date();
        Map<String, String> returnMap = new HashMap<>();
        if ("".equals(DBFFilePath) || DBFFilePath == null || "null".equals(DBFFilePath)) {
            returnMap.put("state", "fail");
            returnMap.put("message", "参数错误");
            return returnMap;
        }
        File file = new File(DBFFilePath);
        if (file.exists()&&file.length() > 0) {
            int index = file.getName().lastIndexOf(".");
            String suf = file.getName().substring(index + 1);
            if (!("dbf".equalsIgnoreCase(suf))) {
                returnMap.put("state", "fail");
                returnMap.put("message", "上传的文件类型错误");
                return returnMap;
            }
            System.out.println("开始解析DBF----");
            Map<String, List> map = null;
            String datype="zwFPT";
            if ("kstzZw".equals(datype)) {//解析指纹特征信息中指纹特征，特殊处理
                File FPTFile = new File(FPTFilePath);
                if (FPTFile == null || !FPTFile.exists()) {
                    returnMap.put("state", "fail");
                    returnMap.put("message", "指纹特征FPT文件不存在");
                    return returnMap;
                }
                map = DBFUtil.readDBFFile(file, FPTFile);
            } else {
                map = DBFUtil.readDBFFile(file, null);
            }
            //获取DBF中列名
            List<String> columns = map.get("column");
            //获取DBF中数据
            List<Map> dataList = map.get("dataList");
            if (dataList == null || dataList.size() == 0) {
                returnMap.put("state", "fail");
                returnMap.put("message", "DBF中数据为空或当前DBF被占用");
                return returnMap;
            }
            System.out.println("解析完成，开始组织数据--------");
            Date miDate = new Date();
            System.out.println("---解析Dbf完成，用时--" + (miDate.getTime() - startDate.getTime()) / 1000 + "秒");
            //插入或更新数据
            Date endDate = new Date();
            System.out.println("解析、插入、校验数据一共用时--" + (endDate.getTime() - startDate.getTime()) / 1000 + "秒");
        } else {
            returnMap.put("state", "fail");
            returnMap.put("message", "文件不存在");
            return returnMap;
        }
        return returnMap;
    }
}
