package com.yodo1.utils;

import com.yodo1.constant.ConstantDefine;

/**
 * Created by YanFeng on 2017/11/10.
 */
public abstract class RedisUtils {

    //App统计用户总量，去重
    static final String APP_AMOUNT_ACC_TOTAL_UNIQUE_KEY = "HLL:amount:total:${key}";
    //App统计活跃量，去重
    static final String APP_ACTIVE_ACC_DAILY_UNIQUE_KEY = "HLL:active:daily:${date}:${key}";
    static final String APP_ACTIVE_ACC_HOURLY_UNIQUE_KEY = "HLL:active:hourly:${date}:${key}";
    static final String APP_ACTIVE_ACC_MONTHLY_UNIQUE_KEY = "HLL:active:monthly:${date}:${key}";
    //广告统计各种行为总量，非去重
    static final String AD_AMOUNT_ACC_HOURLY_NOUNIQUE_KEY = "ACC:amount:hourly:${date}:${key}";
    static final String AD_AMOUNT_ACC_DAILY_NOUNIQUE_KEY = "ACC:amount:daily:${date}:${key}";

    static final String SESSION_KEY = "SESSION:${id}";

    static final String ADEVENT_AMOUNT_ACC_CACHE_MAJOR_KEY = "Cache:AdEvent:${date}";

    public static String AppAmountAccTotalUniqueKeyStr(String majorKey) {
        return APP_AMOUNT_ACC_TOTAL_UNIQUE_KEY.replace("${key}", majorKey);
    }
    public static String AppActiveAccDailyUniqueKeyStr(String majorKey, int dateInt) {
        return APP_ACTIVE_ACC_DAILY_UNIQUE_KEY.replace("${key}", majorKey).replace("${date}",Integer.toString(dateInt));
    }
    public static String AppActiveAccHourlyUniqueKeyStr(String majorKey, int dateInt) {
        return APP_ACTIVE_ACC_HOURLY_UNIQUE_KEY.replace("${key}", majorKey).replace("${date}",Integer.toString(dateInt));
    }
    public static String AppActiveAccMonthlyUniqueKeyStr(String majorKey, int dateInt) {
        return APP_ACTIVE_ACC_MONTHLY_UNIQUE_KEY.replace("${key}", majorKey).replace("${date}",Integer.toString(dateInt));
    }
    public static String ADAmountAccHourlyNoUniqueKeyStr(String majorKey, int dateInt) {
        return AD_AMOUNT_ACC_HOURLY_NOUNIQUE_KEY.replace("${key}", majorKey).replace("${date}",Integer.toString(dateInt));
    }
    public static String ADAmountAccDailyNoUniqueKeyStr(String majorKey, int dateInt) {
        return AD_AMOUNT_ACC_DAILY_NOUNIQUE_KEY.replace("${key}", majorKey).replace("${date}",Integer.toString(dateInt));
    }
    public static String SessionKeyStr(String sessionID)
    {
        return SESSION_KEY.replace("${id}",sessionID);
    }
    public static String ADEventAccCacheMajorKeyStr(String date)
    {
        return ADEVENT_AMOUNT_ACC_CACHE_MAJOR_KEY.replace("${date}",date);
    }

}
