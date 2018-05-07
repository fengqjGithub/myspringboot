package com.joy.java.util.lang;

/**
 * 相关转换工具类
 * Created by jing on 6/30/16.
 */
public class ConvertUtils {

    /**
     * <p>编码为Unicode，格式 '\u0020'.</p>
     *
     * <pre>
     *   CharUtils.unicodeEscaped(' ') = "\u0020"
     *   CharUtils.unicodeEscaped('A') = "\u0041"
     * </pre>
     *
     * @param ch  源字符串
     * @return 转码后的字符串
     */
    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }

    /**
     * Hex to byte[]
     * @param hex
     * @return
     */
    public static byte[] hexToBytes(char[] hex) {
        int length = hex.length / 2;
        byte[] raw = new byte[length];
        for (int i = 0; i < length; i++) {
            int high = Character.digit(hex[i * 2], 16);
            int low = Character.digit(hex[i * 2 + 1], 16);
            int value = (high << 4) | low;
            if (value > 127)
                value -= 256;
            raw[i] = (byte) value;
        }
        return raw;
    }

    /**
     *byte[] 转 Hex
     * @param raw
     * @return
     */
    public static String byteToHex(final byte[] raw) {
        if (raw == null) {
            return null;
        }
        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for (final byte b : raw) {
            final int hiVal = (b & 0xF0) >> 4;
            final int loVal = b & 0x0F;
            hex.append((char) ('0' + (hiVal + (hiVal / 10 * 7))));
            hex.append((char) ('0' + (loVal + (loVal / 10 * 7))));
        }
        return hex.toString();
    }

    /**
     * 功能：将全角的符号转换成半角符号.(即中文字符转英文字符)
     * @param str 源字符串
     * @return String
     */
    public static String changeToHalf(String str) {
        String[] decode = {"1","2","3","4","5","6","7","8","9","0","!","@","#","$","%","^","&","*","(",")","a","b","c","d","e","f","g","h","i","j","k","l"
                ,"m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U"
                ,"V","W","X","Y","Z","-","_","=","+","\\","|","[","]",";",":","'","\"",",","<",".",">","/","?"};
        String source= "１２３４５６７８９０！＠＃＄％︿＆＊（）ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ－＿＝＋＼｜【】；：'\\，〈。〉／？";
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = source.indexOf(str.charAt(i));
            if (pos != -1) {
                result += decode[pos];
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * 功能：将半角的符号转换成全角符号.(即英文字符转中文字符)
     * @param str 源字符串
     * @return String
     */
    public static String changeToFull(String str) {
        String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
        String[] decode = { "１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
                "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
                "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
                "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
                "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
                "'", "\"", "，", "〈", "。", "〉", "／", "？" };
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = source.indexOf(str.charAt(i));
            if (pos != -1) {
                result += decode[pos];
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
