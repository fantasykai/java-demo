package com.fantasykai.java.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2017/11/05 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * The constant yyyyMMddHHmmss.
     */
    public final static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * The constant yyyyMMddHH.
     */
    public final static String yyyyMMddHH = "yyyyMMddHH";

    /**
     * The constant yyyyMMddHH.
     */
    public final static String yyyyMMdd2 = "yyyy/MM/dd";

    /**
     * The constant yyyyMMdd.
     */
    public final static String yyyyMMdd = "yyyyMMdd";

    /**
     * The constant DEFAULT_FORMAT.
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * The constant BIRTHDAY_FORMAT.
     */
    public static final String BIRTHDAY_FORMAT = "MM-dd";

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 根据计算今天与传过来的String类型的字符串相隔天数
     *
     * @param dateStr the date str
     * @return int int
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static int calculateNumberOfDays(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            Date date = sdf.parse(dateStr);
            Date now = new Date();
            long n1 = now.getTime();
            long n2 = date.getTime();
            if (n1 > n2) {
                long diffTime = n1 - n2;
                int numberOfDays = (int) (diffTime / (3600 * 1000 * 24));
                return numberOfDays;
            } else {
                return 0;
            }
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * Gets local time from utc.
     *
     * @param UTCDate the utc date
     * @return the local time from utc
     */
    public static String getLocalTimeFromUTC(Date UTCDate) {
        format.setTimeZone(TimeZone.getDefault());
        return format.format(UTCDate);
    }

    /**
     * 计算穿过来的字符串与今天相隔的天数
     *
     * @param dateStr the date str
     * @return int int
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static int calculateNumberOfDaysToToday(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            Date date = sdf.parse(dateStr);
            Date now = new Date();
            long n1 = now.getTime();
            long n2 = date.getTime();
            if (n2 >= n1) {
                long diffTime = n2 - n1;
                int numberOfDays = (int) (diffTime / (3600 * 1000 * 24));
                return numberOfDays;
            } else {
                return -1;
            }
        } catch (ParseException e) {
            return -1;
        }
    }

    /**
     * 计算每个月的天数
     *
     * @param year 年份
     * @param month 月份
     * @return days 每个月的天数
     */
    public static int getDaysOfMonth(int year, int month) {
        int days = 0;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 9 || month == 10 || month == 12) {
            days = 31;
        } else if (month == 4 || month == 6 || month == 8 || month == 11) {
            days = 30;
        } else { // 2月份，闰年29天、平年28天
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }

        return days;
    }

    /**
     * 计算一年中的天数
     *
     * @return int int
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static int calculateDays() {
        Calendar cd = Calendar.getInstance();
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        return MaxYear;
    }

    /**
     * 计算两个时间相差的天数 输入时间格式: yyyy-MM-dd
     *
     * @param start the start
     * @param end the end
     * @return day diff
     * @throws Exception the exception
     */
    public static int getDayDiff(String start, String end) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0) {
                throw new Exception("开始时间 start > 终止时间 end");
            }
            int day = (int) (interval / (24 * 60 * 60 * 1000));
            return day;
        } catch (ParseException e) {
            throw new Exception("时间格式应为 yyyy-MM-dd");
        }
    }

    /**
     * 计算两个时间相差的秒数 输入时间格式: yyyy-MM-dd HH:mm:ss
     *
     * @param start the start
     * @param end the end
     * @return seconds diff
     * @throws Exception the exception
     */
    public static int getSecondsDiff(String start, String end) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0) {
                throw new Exception("开始时间 start > 终止时间 end");
            }
            int minute = (int) (interval / (1000));
            return minute;
        } catch (ParseException e) {
            throw new Exception("时间格式应为 yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 获取当前时间到第二天凌晨的秒数
     *
     * @return the seconds diff curr
     */
    public static long getSecondsDiffCurr() {
        long milliSecondsLeftToday = (86400000 - org.apache.commons.lang3.time.DateUtils
                .getFragmentInMilliseconds(Calendar.getInstance(), Calendar.DATE)) / 1000;
        return milliSecondsLeftToday;
    }

    /**
     * 计算两个时间相差的分钟数 输入时间格式: yyyy-MM-dd HH:mm:ss
     *
     * @param start the start
     * @param end the end
     * @return minute diff
     * @throws Exception the exception
     */
    public static int getMinuteDiff(String start, String end) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0) {
                throw new Exception("开始时间 start > 终止时间 end");
            }
            int minute = (int) (interval / (60 * 1000));
            return minute;
        } catch (ParseException e) {
            throw new Exception("时间格式应为 yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 根据给定的格式取当前时间。
     * <p>
     * 如果给定的格式为空，则使用默认格式：yyyy-MM-dd HH:mm:ss。
     *
     * @param pattern 指定格式
     * @return 字符串表示的当前时间 date time
     */
    public static String getDateTime(String pattern) {
        if (null == pattern || "".equals(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dt = sdf.format(new Date());
        return dt;
    }

    /**
     * * 功能描述:获取一个小时前的是时间 <br>
     * 〈功能详细描述〉
     * <p>
     * Before one hour to now date string.
     *
     * @param pattern the pattern
     * @return the string
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static String getBeforeOneHourToNowDate(String pattern) {
        Calendar calendar = Calendar.getInstance();
        /* HOUR_OF_DAY 指示一天中的小时 */
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        return df.format(calendar.getTime());
    }

    /**
     * 获取当前时间前几天的时间
     *
     * @param offsetDay the offset day
     * @param strFormat the str format
     * @return date before
     */
    public static String getDateBefore(int offsetDay, String strFormat) {
        String strDay = "";
        long nNow = getTimestamp();
        long mydate = nNow - (long) offsetDay * 24 * 3600 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        strDay = sdf.format(new Date(mydate));
        return strDay;
    }

    /**
     * 获取当前时间戳
     *
     * @return timestamp timestamp
     */
    public static long getTimestamp() {
        Date dateNow = new Date();
        return dateNow.getTime();
    }

    /**
     * 字符串转date类型
     *
     * @param date the date
     * @param pattern the pattern
     * @return date date
     * @throws ParseException the parse exception
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static Date toDate(String date, String pattern) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(date);
    }

    /**
     * 检测日期是否是预期格式
     *
     * @param strTime the str time
     * @param pattern the pattern
     * @return boolean boolean
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static boolean checkDateFormat(String strTime, String pattern) {
        if (strTime.length() != pattern.trim().length())
            return false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern.trim());
            sdf.parse(strTime);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 判断同年同月生日
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return boolean boolean
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 判断同一天生日
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return boolean boolean
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static boolean isSameDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameDate = cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 将日期转化为日期字符串。失败返回null。
     *
     * @param date 日期
     * @param parttern 日期格式
     * @return 日期字符串 string
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static String DateToString(Date date, String parttern) {
        String dateString = null;
        if (date != null) {
            try {
                dateString = getDateFormat(parttern).format(date);
            } catch (Exception e) {
            }
        }
        return dateString;
    }

    /**
     * 获取SimpleDateFormat
     *
     * @param parttern 日期格式
     * @return SimpleDateFormat对象
     * @throws RuntimeException 异常：非法日期格式
     */
    private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {
        return new SimpleDateFormat(parttern);
    }

    /**
     * * 功能描述:UTC 时间格式转换 <br>
     * 〈功能详细描述〉
     * <p>
     * Utc 2 local string.
     *
     * @param utcTime the utc time
     * @param utcTimePatten the utc time patten
     * @param localTimePatten the local time patten
     * @return the string
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    }

    /**
     * * 功能描述: 判断2个时间点是否为同一天<br>
     * 〈功能详细描述〉
     * <p>
     * Judgment same day boolean.
     *
     * @param start the start
     * @param end the end
     * @return the boolean
     * @see [相关类/方法]（可选）
     * @since [产品 /模块版本] （可选）
     */
    public static boolean judgmentSameDay(String start, String end) throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        boolean isSameDay;
        try {
            Date startTime = df.parse(start);
            Date endTime = df.parse(end);
            long interval = endTime.getTime() - startTime.getTime();
            if (interval < 0) {
                throw new Exception("开始时间 start > 终止时间 end");
            }

            isSameDay = startTime.equals(endTime) ? true : false;

        } catch (ParseException e) {
            throw new Exception("时间格式应为 yyyy-MM-dd HH:mm:ss");
        }

        return isSameDay;
    }

}
