package com.joy.java.util.web;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML相关工具类
 */
public class HTMLUtil {

    /**
     * 功能：用于将字符串中的特殊字符转换成Web页中可以安全显示的字符串.
     * 可对表单数据据进行处理对一些页面特殊字符进行处理如'<','>','"',''','&'
     * @param strSrc 要进行替换操作的字符串
     * @return 替换特殊字符后的字符串
     */
    public static String htmlEncode(String strSrc) {
        if (strSrc == null)
            return "";

        //需要进行和转移以后对应的Map
        Map<String,String> coverMap=getHtmlCoverMap();
        for(String key : coverMap.keySet()){
            strSrc = strSrc.replaceAll(key,coverMap.get(key));
        }
        return strSrc;
    }

    /**
     * 功能：用于将字符串中的特殊字符转换成Web页中可以安全显示的字符串.
     * 可对表单数据据进行处理对一些页面特殊字符进行处理如'<','>','"',''','&'
     * @param strSrc 要进行替换操作的字符串
     * @param quotes 为0时单引号和双引号都替换，为1时不替换单引号，为2时不替换双引号，为3时单引号和双引号都不替换
     * @return 替换特殊字符后的字符串
     */
    public static String htmlEncode(String strSrc, int quotes) {
        if (strSrc == null)
            return "";
        if (quotes == 0) {
            return htmlEncode(strSrc);
        }

        char[] arr_cSrc = strSrc.toCharArray();
        StringBuffer buf = new StringBuffer(arr_cSrc.length);
        char ch;

        for (int i = 0; i < arr_cSrc.length; i++) {
            ch = arr_cSrc[i];
            if (ch == '<')
                buf.append("&lt;");
            else if (ch == '>')
                buf.append("&gt;");
            else if (ch == '"' && quotes == 1)
                buf.append("&quot;");
            else if (ch == '\'' && quotes == 2)
                buf.append("&#039;");
            else if (ch == '&')
                buf.append("&amp;");
            else
                buf.append(ch);
        }

        return buf.toString();
    }

    /**
     * 功能：和htmlEncode正好相反
     * @param strSrc 要进行转换的字符串
     * @return 转换后的字符串
     */
    public static String htmlDecode(String strSrc) {
        if (strSrc == null)
            return "";
        //需要进行和转移以后对应的Map
        Map<String,String> coverMap=getHtmlCoverMap();

        for(String key : coverMap.keySet()){
            strSrc = strSrc.replaceAll(coverMap.get(key), key);
        }
        return strSrc;
    }

    /**
     * 生成html转移的键值对应map
     * @return Map<String,String>
     */
    private static Map<String,String> getHtmlCoverMap(){
        Map<String,String> coverMap=new HashMap<String,String>();
        coverMap.put("<", "&lt;");
        coverMap.put(">", "&gt;");
        coverMap.put("\"", "&quot;");
        coverMap.put("'", "&#039;");
        coverMap.put("&", "&amp;");
        return coverMap;
    }

    /**
     * 清除所有的HTML标签
     * @param htmlStr 源字符串
     * @return String
     */
    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        //清除&nbsp;
        htmlStr=htmlStr.replaceAll("&nbsp;","");

        return htmlStr.trim(); //返回文本字符串
    }
}
