package com.joy.java.util.web;

import com.joy.java.util.lang.StringUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 * request response相关工具类
 */
public class WebUtil {
    /**
     * 获取当前请求的全路径，包含参数信息。
     * @param request
     * @return String
     */
    public static String getRequestFullUrl(HttpServletRequest request) {
        String serverName = request.getServerName();
        String referUrl = request.getScheme() + "://" + serverName + ":" + request.getServerPort() + request.getContextPath() + "/" + (StringUtil.isEmpty(request.getQueryString()) ? "" : "?" + request.getQueryString());
        return referUrl;
    }

    /**
     * 获取客户IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = overshot(request);
        return ip;
    }

    /**
     * 设置客户端缓存过期时间 的Header
     * @param response
     * @param expiresSeconds 过期时间
     */
    public static void setExpiresHeader(HttpServletResponse response, long expiresSeconds) {
        // Http 1.0 header, set a fix expires date.
        response.setDateHeader(HttpHeaders.EXPIRES, System.currentTimeMillis() + (expiresSeconds * 1000));
        // Http 1.1 header, set a time after now.
        response.setHeader(HttpHeaders.CACHE_CONTROL, "private, max-age=" + expiresSeconds);
    }

    /**
     * 设置LastModified Header
     * @param response
     * @param lastModifiedDate
     */
    public static void setLastModifiedHeader(HttpServletResponse response, long lastModifiedDate) {
        response.setDateHeader(HttpHeaders.LAST_MODIFIED, lastModifiedDate);
    }

    /**
     * 设置Etag Header
     * @param response
     * @param etag
     */
    public static void setEtag(HttpServletResponse response, String etag) {
        response.setHeader(HttpHeaders.ETAG, etag);
    }

    /**
     * 根据浏览器If-Modified-Since Header, 计算文件是否已被修改.如果无修改, checkIfModify返回false ,设置304 not modify status. 用来判定重复提交
     * @param request
     * @param response
     * @param lastModified 内容的最后修改时间
     * @return boolean
     */
    public static boolean checkIfModifiedSince(HttpServletRequest request, HttpServletResponse response,
                                               long lastModified) {
        long ifModifiedSince = request.getDateHeader(HttpHeaders.IF_MODIFIED_SINCE);
        if ((ifModifiedSince != -1) && (lastModified < (ifModifiedSince + 1000))) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return false;
        }
        return true;
    }

    /**
     * 根据浏览器 If-None-Match Header, 计算Etag是否已无效.如果Etag有效, checkIfNoneMatch返回false, 设置304 not modify status. 用来判定重复提交
     * @param request
     * @param response
     * @param etag 内容的etag
     * @return boolean
     */
    public static boolean checkIfNoneMatchEtag(HttpServletRequest request, HttpServletResponse response, String etag) {
        String headerValue = request.getHeader(HttpHeaders.IF_NONE_MATCH);
        if (headerValue != null) {
            boolean conditionSatisfied = false;
            if (!"*".equals(headerValue)) {
                StringTokenizer commaTokenizer = new StringTokenizer(headerValue, ",");

                while (!conditionSatisfied && commaTokenizer.hasMoreTokens()) {
                    String currentToken = commaTokenizer.nextToken();
                    if (currentToken.trim().equals(etag)) {
                        conditionSatisfied = true;
                    }
                }
            } else {
                conditionSatisfied = true;
            }

            if (conditionSatisfied) {
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                response.setHeader(HttpHeaders.ETAG, etag);
                return false;
            }
        }
        return true;
    }

    /**
     * 设置让浏览器弹出下载对话框的Header,不同浏览器使用不同的编码方式.
     * @param request
     * @param response
     * @param fileName 下载后的文件名
     */
    public static void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
        final String CONTENT_DISPOSITION = "Content-Disposition";
        try {
            String agent = request.getHeader("User-Agent");
            String encodedfileName = null;
            if (null != agent) {
                agent = agent.toLowerCase();
                if (agent.contains("firefox") || agent.contains("chrome") || agent.contains("safari")) {
                    encodedfileName = "filename=\"" + new String(fileName.getBytes(), "ISO8859-1") + "\"";
                } else if (agent.contains("msie")) {
                    encodedfileName = "filename=\"" + URLEncoder.encode(fileName,"UTF-8") + "\"";
                } else if (agent.contains("opera")) {
                    encodedfileName = "filename*=UTF-8\"" + fileName + "\"";
                } else {
                    encodedfileName = "filename=\"" + URLEncoder.encode(fileName,"UTF-8") + "\"";
                }
            }
            response.setHeader(CONTENT_DISPOSITION, "attachment; " + encodedfileName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查是否支持gzip
     * @param request
     * @return
     */
    public static boolean checkAcceptGzip(HttpServletRequest request) {
        // Http1.1 header
        String acceptEncoding = request.getHeader("Accept-Encoding");
        return StringUtils.contains(acceptEncoding, "gzip");
    }

    /**
     * 设置gzip 压缩请求头
     * @param response
     */
    public static void setGzipHeader(HttpServletResponse response) {
        response.setHeader("Content-Encoding", "gzip");
        response.setHeader("Vary", "Accept-Encoding");
    }

    /**
     * 判断是否为ajax 请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request){
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(requestType)){
            return true;
        }
        return false;
    }

    /**
     * 转换客户真实IP地址
     * @param request
     * @return
     */
    private static String overshot(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-forwarded-for");

        if (StringUtils.isBlank(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("X-real-ip");// 自定义的变量名
        }
        if (StringUtils.isBlank(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if ("127.0.0.1".equals(ipAddress)||"0:0:0:0:0:0:0:1".equals(ipAddress)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


}
