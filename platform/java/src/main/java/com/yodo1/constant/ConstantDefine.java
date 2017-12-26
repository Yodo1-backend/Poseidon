package com.yodo1.constant;

/**
 * Created by Yan Feng on 2017/12/27.
 */
public class ConstantDefine {
    public enum OriginDataType
    {
        NULL,
        ILLEGAL,
        APP_LAUNCH,
        APP_TERMINAL,
        APP_EVENT
    }
    public enum TargetDataType
    {
        APP_BASE_COLLECTION,
        APP_ADVERTISING_COLLECTION
    }
    public enum DataProcessResult
    {
        UNKNOWN,
        SUCCESS,
        FAILURE,
        RETRY
    }
    public static final String NULL_STR = "NULL";
    public static final String DEFAULT_STR = "Default";
    public static final String UNKNOWN_STR = "Unknown";

    public static final String APPFIELD_GAME_APPKEY  = "game_appkey";
    public static final String APPFIELD_CHANNEL_CODE = "channel";
    public static final String APPFIELD_VERSION      = "client_version";
    public static final String APPFIELD_EVENTID      = "eventid";
    public static final String APPFIELD_EVENTBODY    = "event_data";
    public static final String APPFIELD_TIMESTAMP    = "timestamp";

   // public static final String DEFAULT_FIELD_CHANNEL_CODE = "unknown";
  //  public static final String DEFAULT_FIELD_VERSION = "unknown";

    public static final String REDIS_KEY_PROVIDER = "Zeus_Data";
    public static final String REDIS_KEY_IMMED_JOB_QUEUE = "JobsQueue:immed";
    public static final String REDIS_KEY_SCHEDULE_JOB_QUEUE = "JobsQueue:schedule";
    public static final String REDIS_KEY_PROCESSING_JOB_QUEUE = "JobsQueue:processing";
    public static final String EVENTTYPE_PROVIDER_APP_LAUNCH = "applaunch";
    public static final String EVENTTYPE_PROVIDER_APP_TERMINAL = "appterminal";
    public static final String EVENTTYPE_PROVIDER_APP_EVENT = "appevent";

    public static final String SPLIT_SYMBOL_SESSION = "___";

    public static final int REDIS_EXPIRE_SESSION = 1000 * 60 * 24; //session生命周期为一天

    public static final int JOB_EXPIRE = 1000 * 60 * 10; //任务超时时间为10分钟

    public static final int SLEEP_DURATION_QUEUE_FULL = 200;       //队列如果满了则等待200ms
    public static final int SLEEP_DURATION_ORIGIN_EMPTY = 1000 * 1;       //队列如果满了则等待1s
    public static final int SLEEP_DURATION_POLLING_SCHEDULE = 1000 * 10;  //计划任务的即时轮询间隔10s
    public static final int SLEEP_DURATION_POLLING_SCHEDULE_WITHOUT_JOB =  1000 * 10; //计划任务的轮询间隔1分钟
}
