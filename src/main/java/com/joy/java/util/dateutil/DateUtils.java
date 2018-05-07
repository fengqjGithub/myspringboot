package com.joy.java.util.dateutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    private StringBuffer buffer = new StringBuffer();
    private static String ZERO = "0";
    private static DateUtils date;
    public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    public String getNowString() {
        Calendar calendar = getCalendar();
        buffer.delete(0, buffer.capacity());
        buffer.append(getYear(calendar));

        if (getMonth(calendar) < 10) {
            buffer.append(ZERO);
        }
        buffer.append(getMonth(calendar));

        if (getDate(calendar) < 10) {
            buffer.append(ZERO);
        }
        buffer.append(getDate(calendar));
        if (getHour(calendar) < 10) {
            buffer.append(ZERO);
        }
        buffer.append(getHour(calendar));
        if (getMinute(calendar) < 10) {
            buffer.append(ZERO);
        }
        buffer.append(getMinute(calendar));
        if (getSecond(calendar) < 10) {
            buffer.append(ZERO);
        }
        buffer.append(getSecond(calendar));
        return buffer.toString();
    }

    private static int getDateField(Date date,int field) {
        Calendar c = getCalendar();
        c.setTime(date);
        return c.get(field);
    }
    public static int getYearsBetweenDate(Date begin,Date end){
        int bYear=getDateField(begin,Calendar.YEAR);
        int eYear=getDateField(end,Calendar.YEAR);
        return eYear-bYear;
    }

    public static int getMonthsBetweenDate(Date begin,Date end){
        int bMonth=getDateField(begin,Calendar.MONTH);
        int eMonth=getDateField(end,Calendar.MONTH);
        return eMonth-bMonth;
    }
    public static int getWeeksBetweenDate(Date begin,Date end){
        int bWeek=getDateField(begin,Calendar.WEEK_OF_YEAR);
        int eWeek=getDateField(end,Calendar.WEEK_OF_YEAR);
        return eWeek-bWeek;
    }
    public static int getDaysBetweenDate(Date begin,Date end){
        int bDay=getDateField(begin,Calendar.DAY_OF_YEAR);
        int eDay=getDateField(end,Calendar.DAY_OF_YEAR);
        return eDay-bDay;
    }


    /**
     * 获取date年后的amount年的第一天的开始时间
     *
     * @param amount
     *            可正、可负
     * @return
     */
    public static Date getSpecficYearStart(Date date,int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, amount);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return getStartDate(cal.getTime());
    }

    /**
     * 获取date年后的amount年的最后一天的终止时间
     *
     * @param amount
     *            可正、可负
     * @return
     */
    public static Date getSpecficYearEnd(Date date,int amount) {
        Date temp = getStartDate(getSpecficYearStart(date,amount + 1));
        Calendar cal = Calendar.getInstance();
        cal.setTime(temp);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return getFinallyDate(cal.getTime());
    }

    /**
     * 获取date月后的amount月的第一天的开始时间
     *
     * @param amount
     *            可正、可负
     * @return
     */
    public static Date getSpecficMonthStart(Date date,int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, amount);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getStartDate(cal.getTime());
    }

    /**
     * 获取当前自然月后的amount月的最后一天的终止时间
     *
     * @param amount
     *            可正、可负
     * @return
     */
    public static Date getSpecficMonthEnd(Date date,int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getSpecficMonthStart(date,amount + 1));
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return getFinallyDate(cal.getTime());
    }

    /**
     * 获取date周后的第amount周的开始时间（这里星期一为一周的开始）
     *
     * @param amount
     *            可正、可负
     * @return
     */
    public static Date getSpecficWeekStart(Date date,int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
        cal.add(Calendar.WEEK_OF_MONTH, amount);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return getStartDate(cal.getTime());
    }

    /**
     * 获取date周后的第amount周的最后时间（这里星期日为一周的最后一天）
     *
     * @param amount
     *            可正、可负
     * @return
     */
    public static Date getSpecficWeekEnd(Date date,int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
        cal.add(Calendar.WEEK_OF_MONTH, amount);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getFinallyDate(cal.getTime());
    }

    public static Date getSpecficDateStart(Date date,int amount){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, amount);
        return getStartDate(cal.getTime());
    }

    /**
     * 得到指定日期的一天的的最后时刻23:59:59
     *
     * @param date
     * @return
     */
    public static Date getFinallyDate(Date date) {
        String temp = format.format(date);
        temp += " 23:59:59";

        try {
            return format1.parse(temp);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 得到指定日期的一天的开始时刻00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        String temp = format.format(date);
        temp += " 00:00:00";

        try {
            return format1.parse(temp);
        } catch (Exception e) {
            return null;
        }
    }

    private int getYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    private int getMonth(Calendar calendar) {
        return calendar.get(Calendar.MONDAY) + 1;
    }

    private int getDate(Calendar calendar) {
        return calendar.get(Calendar.DATE);
    }

    private int getHour(Calendar calendar) {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    private int getMinute(Calendar calendar) {
        return calendar.get(Calendar.MINUTE);
    }

    private int getSecond(Calendar calendar) {
        return calendar.get(Calendar.SECOND);
    }

    private static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static DateUtils getDateInstance() {
        if (date == null) {
            date = new DateUtils();
        }
        return date;
    }

    /**
     * 是否是今天。根据System.currentTimeMillis() / 1000 / 60 / 60 / 24计算。
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        long day = date.getTime() / 1000 / 60 / 60 / 24;
        long currentDay = System.currentTimeMillis() / 1000 / 60 / 60 / 24;
        return day == currentDay;
    }

    /**
     *
     * @param date
     *            判断是否是本周，取出日期，依据日期取出该日所在周所有日期，在依据这些日期是否和本日相等
     * @return
     */
    public static boolean isThisWeek(Date date) {
        List<Date> dates = dateToWeek(date);
        Boolean flag = false;
        for (Date d : dates) {
            if (isToday(d)) {
                flag = true;
                break;
            } else {
                continue;
            }
        }
        return flag;
    }

    /**
     *
     * @param date
     *            判断是否是本月的日期
     * @return
     */
    public static boolean isThisMonth(Date date) {
        long year = date.getYear();
        long month = date.getMonth();
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().getYear() == year
                && calendar.getTime().getMonth() == month;
    }

    /**
     *
     * @param date
     *            判断是否是本年的日期
     * @return
     */
    public static boolean isThisYear(Date date) {
        long year = date.getYear();
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().getYear() == year;
    }

    /**
     *
     * @param mdate
     *            取出改日的一周所有日期
     * @return
     */
    public static List<Date> dateToWeek(Date mdate) {
        int day = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList();
        Long fTime = mdate.getTime() - day * 24 * 3600000;
        for (int i = 0; i < 7; i++) {
            fdate = new Date();
            fdate.setTime(fTime + (i * 24 * 3600000));
            list.add(i, fdate);
        }
        return list;
    }

    public static Double diffTwoDate(Date begin, Date end) {
        return (end.getTime() - begin.getTime()) / 1000 / 60.0;
    }

    public static String parseDate(Date date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        String dateString;
        dateString = formater.format(date);
        return dateString;
    }

    public static Date afterDate(Date date, Integer after) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + after);
        return calendar.getTime();
    }

    public static final class Patten {
        public static String Patten1 = "yyyy-MM-dd";
        public static String Patten2 = "yyyy-MM-dd HH:mm:ss";
    }


    public static int getHour(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinite(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.MINUTE);
    }

    public static int getSecond(Date d) {
        if (d == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.SECOND);
    }

    public static Date getUtilDate(String str) {
        return getUtilDate(str, "yyyy-MM-dd");
    }

    public static Date getUtilDate(String str, String patten) {
        if (str == null) {
            return null;
        }
        if (patten == null) {
            patten = "yyyy-MM-dd";
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat(patten);
            return dateFormat.parse(str);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String formatDate(Date date, String patten) {
        String str = null;
        if (date != null) {
            if (patten == null) {
                patten = DateUtils.Patten.Patten1;
            }
            DateFormat dateFormat = new SimpleDateFormat(patten);
            str = dateFormat.format(date);
        }
        return str;
    }

    public static String formatDate(Date date) {
        return formatDate(date, DateUtils.Patten.Patten1);
    }

    /**
     *
     * @param date String 2006-01-01 10:01:56.456
     * @return java.sql.Timestamp
     */
    public static java.sql.Timestamp getTimestamp(String str) {
        if (str == null) {
            return null;
        }
        try {
            return (java.sql.Timestamp.valueOf(str));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public final static java.sql.Timestamp getTimestamp(String dateString, String patten) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(patten);
        Date timeDate = dateFormat.parse(dateString);// util类型
        java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
        return dateTime;
    }

    /**
     * 当前时间，毫秒为0
     *
     * @return Timestamp
     */
    public static java.sql.Timestamp getTimestamp() {
        return getTimestamp(new Date(System.currentTimeMillis()), new java.sql.Time(System.currentTimeMillis()));
    }

    public static java.sql.Timestamp getTimestamp(Date d, java.sql.Time t) {
        if (d == null) {
            d = new Date(System.currentTimeMillis());
        }
        if (t == null) {
            t = new java.sql.Time(System.currentTimeMillis());
        }
        try {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            c3.set(Calendar.MILLISECOND, 0);
            c1.setTime(d);
            c2.setTime(t);
            c3.set(c1.get(Calendar.YEAR), c1.get(Calendar.MARCH), c1.get(Calendar.DATE), c2.get(Calendar.HOUR_OF_DAY), c2.get(Calendar.MINUTE), c2
                    .get(Calendar.SECOND));
            return (new java.sql.Timestamp(c3.getTimeInMillis()));
        } catch (Exception ex) {
            return null;
        }
    }

    public static java.sql.Timestamp getTimestamp(Date d) {
        if (d == null) {
            d = new Date(System.currentTimeMillis());
        }
        try {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(d);
            return (new java.sql.Timestamp(c1.getTimeInMillis()));
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * @param str String 10:05
     * @return Time
     */
    public static java.sql.Time getTimeWithoutSecond(String str) {
        return getTime(str, "HH:mm");
    }

    /**
     *
     * @param str String 10:05:01
     * @return Time
     */
    public static java.sql.Time getTime(String str) {
        return getTime(str, "HH:mm:ss");
    }

    public static java.sql.Time getTime(String str, String patten) {
        if (str == null) {
            return null;
        }
        if (patten == null) {
            patten = "HH:mm:ss";
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat(patten);
            Date d = dateFormat.parse(str);
            return getTime(d);
        } catch (Exception ex) {
            return null;
        }

    }

    public static java.sql.Time getTime(Date d) {
        if (d == null) {
            return null;
        }
        return (new java.sql.Time(d.getTime()));
    }

    public static java.sql.Date getSqlDate(String str) {
        return getSqlDate(str, "yyyy-MM-dd");
    }

    public static java.sql.Date getSqlDate(String str, String patten) {
        if (str == null) {
            return null;
        }
        if (patten == null) {
            patten = "yyyy-MM-dd";
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat(patten);
            Date ud = dateFormat.parse(str);
            return new java.sql.Date(ud.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

    public static java.sql.Date getSqlDate(java.sql.Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return (new java.sql.Date(timestamp.getTime()));
    }

    public static java.sql.Time getTime(java.sql.Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return (new java.sql.Time(timestamp.getTime()));
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2
                .get(Calendar.DAY_OF_YEAR));
    }

    public static boolean isSameTime(java.sql.Time time1, java.sql.Time time2) {
        if (time1 == null || time2 == null) {
            throw new IllegalArgumentException("The time must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(time1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(time2);
        return isSameTime(cal1, cal2);
    }

    public static boolean isSameTime(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY) && cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE) && cal1
                .get(Calendar.SECOND) == cal2.get(Calendar.SECOND));
    }

    public static boolean isSameTimestamp(java.sql.Timestamp timestamp1, java.sql.Timestamp timestamp2) {
        if (timestamp1 == null || timestamp2 == null) {
            throw new IllegalArgumentException("The timestamp must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(timestamp1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(timestamp2);
        return isSameTimestamp(cal1, cal2);
    }

    public static boolean isSameTimestamp(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)
                && cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE) && cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND) && cal1
                .get(Calendar.MILLISECOND) == cal2.get(Calendar.MILLISECOND));
    }

    private static Vector HOUR_LIST;
    private static Vector MINUTE_LIST;
    private static Vector SECOND_LIST;


    public static String dateDiff(Date startTime, Date endTime) {
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        String diffValue = null;
        try {
            // 获得两个时间的毫秒时间差异
            diff = endTime.getTime() - startTime.getTime();
            long day = diff / nd;// 计算差多少天
            long hour = diff % nd / nh;// 计算差多少小时
            long min = diff % nd % nh / nm;// 计算差多少分钟
//			long sec = diff % nd % nh % nm / ns;// 计算差多少秒
            // 输出结果
//			System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒。");
            diffValue =  day + "天" + hour + "小时" + min + "分钟";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffValue;
    }
}
