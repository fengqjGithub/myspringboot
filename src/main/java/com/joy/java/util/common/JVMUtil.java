package com.joy.java.util.common;

/**
 * 获得JVM相关信息。
 */
public class JVMUtil {

    public JVMUtil() {

    }

    /**
     * java版本号
     * @return String
     */
    public static String getVersion() {
        return System.getProperty("java.version");
    }

    /**
     * JAVA HOME
     * @return String
     */
    public static String getJAVAHome() {
        return System.getProperty("java.home");
    }

    /**
     * Java类版本号
     * @return String
     */
    public static String getClassVersion() {
        return System.getProperty("java.class.version");
    }

    /**
     * Java类路径
     * @return String
     */
    public static String getClassPath() {
        return System.getProperty("java.class.path");
    }

    /**
     * Java lib路径
     * @return String
     */
    public static String getLibPath() {
        return System.getProperty("java.library.path");
    }

    /**
     * Java输入输出临时路径
     * @return String
     */
    public static String getIOTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 操作系统名称
     * @return String
     */
    public static String getOSName() {
        return System.getProperty("os.name");
    }

    /**
     * 操作系统版本号
     * @return String
     */
    public static String getOSVersion() {
        return System.getProperty("os.version");
    }

    /**
     * 文件分隔符
     * @return String
     */
    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * 路径分隔符
     * @return String
     */
    public static String getPathSeparator() {
        return System.getProperty("path.separator");
    }

    /**
     * 换行符
     * @return String
     */
    public static String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    /**
     * 当前用户名称
     * @return String
     */
    public static String getName() {
        return System.getProperty("user.name");
    }

    /**
     * 当前用户家目录
     * @return String
     */
    public static String getHome() {
        return System.getProperty("user.home");
    }

    /**
     * 当前程序所在目录
     * @return String
     */
    public static String getDir() {
        return System.getProperty("user.dir");
    }
}
