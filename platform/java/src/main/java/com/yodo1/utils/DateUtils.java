package com.yodo1.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
/**
 * Created by YanFeng on 2017/11/13.
 */
public abstract class DateUtils {

    public enum DateFormat
    {
        SECOND,
        HOURLY,
        DAILY,
        WEEKLY,
        MONTHLY
    }
    private static final long TIME_ANCHOR_MILLISECOND = 946656000000L;//2000.01.01.00:00:00的毫秒时间戳
    private static final long TIMESPAN_MS_HOUR = 1000 * 60 * 60;
    private static final long TIMESPAN_MS_DAY  = 1000 * 60 * 60 * 24;
    private static final long TIMESPAN_MS_WEEK = 1000 * 60 * 60 * 24 * 7;
    public static final long GetCurrentMiles()
    {
        return System.currentTimeMillis();
    }
    public static Integer GetIntegerForDate(DateFormat format)
    {
        return GetIntegerForDate(format,new Date());
    }
    public static Integer GetIntegerForDate(DateFormat format,Date date)
    {
        SimpleDateFormat formatter = null;
        Integer result = 0;
        if(null != date)
        {
            switch (format)
            {
                case SECOND:{
                    formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                }break;
                case HOURLY:{
                    formatter = new SimpleDateFormat("yyyyMMddHH");
                }break;
                case DAILY:{
                    formatter = new SimpleDateFormat("yyyyMMdd");
                }break;
                case WEEKLY:{
                    formatter = new SimpleDateFormat("yyyyMMdd");
                }break;
                case MONTHLY:{
                    formatter = new SimpleDateFormat("yyyyMM");
                }break;
                default:result = 0;
            }
        }
        if(null != formatter)
        {
            String dateString = formatter.format(date);
            result = Integer.parseInt(dateString);
        }
        return result;
    }
    public static Pair<DateFormat,Integer> GetDiffBetweenNow(long timeStampInMillis)
    {
        Pair<DateFormat,Integer> result = new Pair<>(DateFormat.SECOND,0);
        long diff = DateUtils.GetCurrentMiles() - timeStampInMillis;
        if(diff >= TIMESPAN_MS_WEEK)
        {
            result =new Pair<>(DateFormat.WEEKLY,new Long(diff/TIMESPAN_MS_WEEK).intValue());
        }
        else if(diff >= TIMESPAN_MS_DAY)
        {
            result =new Pair<>(DateFormat.DAILY,new Long(diff/TIMESPAN_MS_DAY).intValue());
        }
        else if(diff >= TIMESPAN_MS_HOUR)
        {
            result =new Pair<>(DateFormat.HOURLY,new Long(diff/TIMESPAN_MS_HOUR).intValue());
        }
        return result;
    }
    public static boolean IfInToday(long timeStampInMillis)
    {
        Calendar now = Calendar.getInstance();
        clearCalendar(now, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND);

        return (timeStampInMillis-now.getTimeInMillis()) < TIMESPAN_MS_DAY;
    }
    public static boolean IfIn48H(long timeStampInMillis)
    {
        return (DateUtils.GetCurrentMiles() - timeStampInMillis) <= (TIMESPAN_MS_HOUR * 48);
    }
    public static boolean IfInDiffMonth(long timeStampInMillis) {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);
        calendar.setTimeInMillis(timeStampInMillis);
        return (nowYear != calendar.get(Calendar.YEAR)) || (nowMonth != calendar.get(Calendar.MONTH));
    }

    public static Integer GetFormattedTimeInt(DateFormat format, long timeStampInMillis)
    {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(timeStampInMillis);
        switch (format)
        {
            case SECOND:
            case HOURLY:{
                return now.get(Calendar.YEAR) * 1000000 + now.get(Calendar.MONTH) * 10000 + now.get(Calendar.DAY_OF_MONTH) * 100 + now.get(Calendar.HOUR_OF_DAY);
            }
            case DAILY:
            case WEEKLY:
            case MONTHLY:{
                return now.get(Calendar.YEAR) * 10000 + now.get(Calendar.MONTH) * 100 + now.get(Calendar.DAY_OF_MONTH);
            }
            default:return 0;
        }
    }
    public static Long GetTimestampInHour(long timeStamp)
    {
        if(ifMillis(timeStamp))
        {
            return (timeStamp / (1000 * 3600));
        }
        else
        {
            return timeStamp / 3600;
        }
    }
    private static boolean ifMillis(long timeStamp)
    {
        return timeStamp >= TIME_ANCHOR_MILLISECOND;
    }
    private static void clearCalendar(Calendar c, int... fields) {
        for (int f : fields) {
            c.set(f, 0);
        }
    }


}
