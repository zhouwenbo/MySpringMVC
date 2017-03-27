package com.fheebiy.common;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {


    public static final long ONE_SECOND = 1000l;

    public static final long ONE_MINUTE = 60 * ONE_SECOND;

    public static final long ONE_HOUR = 60 * ONE_MINUTE;

    public static Date parseDate(String dateStr) {
        try {
            String[] parsePatterns = {
                    "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
                    "yyyy:MM:dd HH:mm:ss", "yyyy-MM-dd",
                    "dd.MM.yy HH:mm", "yyyyMMdd HHmmss",
                    "yyyyMMdd HHmm", "MM/dd/yy hh:mm a",
                    "HH:mm:ss dd.MM.yyyy", "yyyy:MM:dd",
                    "yyyy:MM:dd HH:mm", "dd.MM.yy", "yyyyMMdd",
                    "EEE, dd MMM yyyy HH:mm:ss", "MM/dd/yy",
                    "yyyy:MM:dd HH:mm:sss",
                    "yyyy/MM/dd"
            };
            return DateUtils.parseDate(dateStr, parsePatterns);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format(Date date, String formatter) {
        if (date != null) {
            try {
                return new SimpleDateFormat(formatter).format(date);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static Date getFirsDateTimeOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1, 0, 0, 0);
        return calendar.getTime();
    }

    public static String currentDate_No_Split() {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(calendar.getTime());
    }

    public static boolean isCurrentYear(Date date) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) == currentYear;
    }

    /**
     * 0:00日期处理
     *
     * @param endtime
     * @return
     */
    public static Date getDateMinusOneDay(Date endtime) {
        if (endtime != null && !endtime.equals("")) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(endtime);
            calendar.add(calendar.DATE, 1);
            endtime = calendar.getTime();
        }
        return endtime;
    }

    public static void main(String[] args) {
        Date d = getFirsDateTimeOfMonth(2013, 9);
        System.out.println(d.toLocaleString());
        Date date = new Date();
        System.out.println(isCurrentYear(date));
    }

}
