package com.yc.common.utils;

import com.yc.common.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 村子里最好的剑
 */
public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {

    }

    /**
     * getDate
     *
     * @param time
     * @return format[yyyy-MM-dd]
     */
    public static String getDate(Date time) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(time);
    }

    /**
     * Date 20100322
     *
     * @param checkString 要验证的邮件地址字符串
     * @return 验证邮件地址是否合法，如果合法则返回true,否则返回false
     */
    public static boolean isEmail(String checkString) {
        String regString = "([a-zA-Z_0-9]+)@([a-zA-Z0-9]+)\\.([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(checkString);
        return matcher.find();
    }

    public static String formatDate(Date time, String pattern) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(time);
    }

    /**
     * isInRange
     *
     * @param startDate
     * @param endDate
     * @return
     */

    public static boolean isInRange(Timestamp startDate, Timestamp endDate) {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        return (startDate == null || !startDate.after(current)) && (endDate == null || !endDate.before(current));
    }

    /**
     * getTime
     *
     * @param time
     * @return format[yyyy-MM-dd HH:mm:ss]
     */
    public static String getTime(Date time) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }

    /**
     * getTime
     *
     * @param time
     * @return format[yyyyMMddHHmmss]
     */
    public static String getTimeTrim(Date time) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(time);
    }

    /**
     * getTime
     *
     * @param time
     * @param pattern
     * @return format[yyyy-MM-dd HH:mm:ss]
     */
    public static String getStrTime(Timestamp time, String pattern) {
        if (time == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(time);
    }

    /**
     * parseTime
     *
     * @param time [yyyy-MM-dd HH:mm:ss]
     * @return Date
     */
    public static Date parseTime(String time) {
        if (time == null || time.length() < 1) {
            return null;
        }
        Date result = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            result = df.parse(time);
        } catch (ParseException e) {
            return null;
        }
        return result;
    }

    /**
     * parseTimeStamp
     *
     * @param time [yyyy-MM-dd HH:mm:ss]
     * @return Timestamp
     */
    public static Timestamp parseTimeStamp(String time) {

        Date result = parseTime(time);
        if (result != null) {
            return new Timestamp(result.getTime());
        }
        return null;

    }

    /**
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @return
     */
    public static Timestamp getNextDay() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, Constant.NUM_1);
        return new Timestamp(now.getTimeInMillis());
    }

    public static String getCurrentDate() {
        return getDate(new Date());
    }

    public static String getCurrentTime() {
        return getTime(new Date());
    }

    public static Timestamp getCurrentTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getTimeStampString() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    public static Date getDateDiff(Date time, int days) {
        if (time == null) {
            return null;
        }
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(time);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0,
                0);
        tempCal.add(Calendar.DAY_OF_MONTH, days);
        return tempCal.getTime();
    }

    /**
     * 日期加上分钟数
     *
     * @param time
     * @param minutes
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date getMinuteDiff(Date time, int minutes) {
        if (time == null) {
            return null;
        }
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(time);
        tempCal.add(Calendar.MINUTE, minutes);
        return tempCal.getTime();
    }

    /**
     * 为商品组取js,css版本号 getDate
     *
     * @return format[yyyyMMddHH]
     */
    public static String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    /**
     * parseDate
     *
     * @param date date
     * @return format[yyyyMMdd]
     */
    public static String parseDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(date);
    }

    /**
     * 功能描述: 日期格式化
     */
    public static String dateFormat(Date date, String pattern) {
        String result = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 功能描述: 日期计算
     */
    public static String addDay(String date, String pattern, long days) {
        String result = "";
        if (date != null && !"".equals(date.trim())) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                Date d = sdf.parse(date);
                result = sdf.format(new Date(d.getTime() + days * Constant.DAY_MILL_SECONDS));
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e.getMessage());
            }
        }

        return result;
    }

    /**
     *
     * @param date
     * @param pattern
     * @param minutes
     * @return
     */
    public static String addMinutes(String date, String pattern, long minutes){
        String result = "";
        if (date != null && !"".equals(date.trim())) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                Date d = sdf.parse(date);
                result = sdf.format(new Date(d.getTime() + minutes * Constant.NUM_60000));
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e.getMessage());
            }
        }
        return result;
    }

    /**
     * 功能描述: 计算当前时间与第二日零点的时间差
     */
    public static int timeDistance() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH),
                curDate.get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) ((tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / Constant.NUM_1000);
    }

    public static int compare(String t1, String t2) {
        // 转换为Date对象
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 转换为Date对象
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df1.parse(t1);
            Date d2 = df2.parse(t2);
            // 再比较时间
            return d1.compareTo(d2);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e.getMessage());
            return 0;
        }
    }

    /**
     * 获取活动持续时间，单位是毫秒
     *
     * @param start 活动信息
     * @return 时间
     */
    public static int getActTime(String start, String end) {
        Date startTime = DateUtil.parseTime(start);
        Date endTime = DateUtil.parseTime(end);
        return (int) (endTime.getTime() - startTime.getTime());
    }

    /**
     * 获取活动持续时间，单位是毫秒
     *
     * @param start 活动信息
     * @return 时间
     */
    public static int getTimeDiff(Timestamp start, Timestamp end) {
        return (int) (end.getTime() - start.getTime());
    }


    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param hour
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String addHourTime(int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - hour);
        return sdf.format(ca.getTime());
    }

    /**
     * 功能描述: <br>
     * 获取min分钟前的时间
     *
     * @param min
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Timestamp addMinTime(int min) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) - min);
        return Timestamp.valueOf(sdf.format(ca.getTime()));
    }

    /**
     * 功能描述: <br>
     * 获取min分钟前的时间
     *
     * @param min
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Timestamp afterMinTime(int min) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) + min);
        return Timestamp.valueOf(sdf.format(ca.getTime()));
    }

    /**
     * 功能描述: timeStamp2Date<br>
     * 〈功能详细描述〉
     *
     * @param timestampString
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Date timeStamp2Date(String timestampString) {
        Long timestamp = Long.parseLong(timestampString);
        Date date = new Date(timestamp);
        return date;
    }

    /**
     * 功能描述: 获得与当前时间的天数差（当前日期-入参日期）<br>
     * 〈功能详细描述〉
     *
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getSubDays(Date date) {
        Date d2 = new Date();
        long day = (d2.getTime() - date.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 功能描述: 获得与当前时间的小时差（当前时间-入参时间）<br>
     * 〈功能详细描述〉
     *
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static long getSubHours(Date date) {
        Date d2 = new Date();
        long day = (d2.getTime() - date.getTime()) / (60 * 60 * 1000);
        return day;
    }

    /**
     * 计算时间差，小时
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getSubHours(String startTime, String endTime) {
        // 转换为Date对象
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 转换为Date对象
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df1.parse(startTime);
            Date d2 = df2.parse(endTime);
            return (d2.getTime() - d1.getTime()) / (60 * 60 * 1000);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e.getMessage());
            return 0;
        }
    }

    /**
     * 计算时间差，小时
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static double getHours(String startTime, String endTime) {
        // 转换为Date对象
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 转换为Date对象
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d1 = df1.parse(startTime);
            Date d2 = df2.parse(endTime);
            DecimalFormat df = new DecimalFormat("0.0");//设置保留位数
            return Double.parseDouble(df.format((float) (d2.getTime() - d1.getTime()) / (60 * 60 * 1000)));
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e.getMessage());
            return 0;
        }
    }


    public static String getslongToString(long date) {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdFormat.format(date);
    }

    /**
     * 返回两个时间之间的所有时间集合 [2019-08-01, 2019-08-02, 2019-08-03, 2019-08-04, 2019-08-05, 2019-08-06]
     *
     * @param startTime 开始时间  2019-08-01
     * @param endTime   结束时间 2019-08-06
     * @return
     */
    public static List<String> getBetweenDate(String startTime, String endTime, String format) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 与当前时间比较是否小于当前时间
     *
     * @param time 比较时间  2019-09-23
     * @return
     */
    public static Boolean compareToTime(String time) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long str1date = dateFormat.parse(time).getTime();
            long str2date = dateFormat.parse(getDate(new Date())).getTime();
            if (str2date - str1date > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化  yyyy-MM-dd
     *
     * @param time
     */
    public static Date parse2Time(String time) {
        if (time == null || time.length() < 1) {
            return null;
        }
        Date result = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            result = df.parse(time);
        } catch (ParseException e) {
            return null;
        }
        return result;
    }

    /**
     * 验证时间字符串格式输入是否正确
     *
     * @param timeStr 2020-10-12
     * @return
     */
    public static boolean valiDateTimeWithLongFormat(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m - 1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 验证时间字符串格式输入是否正确
     *
     * @param timeStr 2020-10
     * @return
     */
    public static boolean valiDateTimeWithLongFormat2(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 根据年月 返回该月份的所有日期 [2019/10/1, 2019/10/2, 2019/10/3, 2019/10/4, 2019/10/5, 2019/10/6]
     *
     * @param time 2019-10
     * @return
     */
    public static List<String> getMonthDaysTime(String time) {
        List<String> days = new ArrayList<String>();
        Calendar cd = Calendar.getInstance();
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM").parse(time);
            cd.setTime(date);
            int year = cd.get(Calendar.YEAR);
            int month = cd.get(Calendar.MONTH);
            int day = 0;
            int[] monDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            day = monDays[month];
            if (((year) % 4 == 0 && (year) % 100 != 0) || (year) % 400 == 0) {
                if (1 == month) {
                    day = 29;
                }
            }
            for (int i = 1; i <= day; i++) {
                days.add(year + "/" + (month + 1) + "/" + i);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 返回 2019-01
     *
     * @param time 2019-1-10
     * @return 2019-01
     */
    public static String getMonthStr(String time) {
        String month = time.substring(time.indexOf("-") + 1, time.lastIndexOf("-"));
        if (Integer.valueOf(month) >= 10) {
            return time.substring(0, time.lastIndexOf("-"));
        }
        String year = time.substring(0, time.indexOf("-"));

        StringBuffer buffer = new StringBuffer(year);
        buffer.append("-");
        buffer.append("0").append(month);
        return buffer.toString();
    }

    /**
     * 返回 01
     *
     * @param time 2019-1-1
     * @return 01
     */
    public static String getDayStr(String time) {
        String day = time.substring(time.lastIndexOf("/") + 1);
        if (Integer.valueOf(day) >= 10) {
            return day;
        }
        StringBuffer buffer = new StringBuffer("0");
        buffer.append(day);
        return buffer.toString();
    }

    /**
     * 拼接时间
     * @param date
     * @param time
     * @return
     */
    public static String getDateTime(String date, String time){
        StringBuilder builder = new StringBuilder();
        builder.append(date).append(" ").append(time);
        return builder.toString();
    }

    /**
     * 返回1小时40分
     * @param minutes 100
     * @return
     */
    public static String getHourMinuteStr(Long minutes){
        StringBuilder builder = new StringBuilder();
        //小时的计算
        Long hour = minutes / 60;
        if(hour != 0){
            builder.append(String.valueOf(hour)).append("小时");
        }
        //分的计算
        Long minute = minutes % 60;
        if(minute != 0){
            builder.append(String.valueOf(minute)).append("分");
        }
        return builder.toString();
    }

    public static String getStringDate(Long date,SimpleDateFormat longHour) throws ParseException{
        Date time = new Date(date * 1000);
        String creaeTime = longHour.format(time);
        return creaeTime;
    }

    /**
     * 判断 是否是 2020-05-01  格式
     * @param sDate
     * @return
     */
    public static boolean isValidDate(String sDate) {
        String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
        String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
                + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
                + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
                + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
                + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
                + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        if ((sDate != null)) {
            Pattern pattern = Pattern.compile(datePattern1);
            Matcher match = pattern.matcher(sDate);
            if (match.matches()) {
                pattern = Pattern.compile(datePattern2);
                match = pattern.matcher(sDate);
                return match.matches();
            }
            else {
                return false;
            }
        }
        return false;
    }

    public  static String getShortTime() {
        String hours, minutes, seconds;
        if (getHour() < 10) {
            hours = "0" + getHour();
        } else {
            hours = String.valueOf(getHour());
        }

        if (getMinute() < 10) {
            minutes = "0" + getMinute();
        } else {
            minutes = String.valueOf(getMinute());
        }

        if (getSecond() < 10) {
            seconds = "0" + getSecond();
        } else {
            seconds = String.valueOf(getSecond());
        }

        return hours + minutes + seconds;
    }

    /**
     * 取小时 hh
     *
     * @return int
     */
    public static int getHour() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取分钟 mm
     *
     * @return int
     */
    public static int getMinute() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 取秒钟 ss
     *
     * @return int
     */
    public static int getSecond() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        return calendar.get(Calendar.SECOND);
    }

    public static void main(String[] args) {
        System.out.println(parseDate(new Date()));
    }
}