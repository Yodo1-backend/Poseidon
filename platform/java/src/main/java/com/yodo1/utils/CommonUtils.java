package com.yodo1.utils;

import com.yodo1.constant.ConstantDefine;


import java.net.InetAddress;

/**
 * Created by YanFeng on 2017/11/20.
 */
public abstract class CommonUtils {

    public static final boolean isNotNullStr(String str)
    {
        return null != str && !"".equals(str) && !ConstantDefine.NULL_STR.equals(str);
    }
    public static final String CalculateAppStatisticsID(String game_appkey, String channel_code, String version)
    {
        return RSAUtils.SHA1(game_appkey+channel_code+version);
    }
    public static String GetMachineName()
    {
        try
        {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e)
        {
            return ConstantDefine.UNKNOWN_STR;
        }
    }
}
