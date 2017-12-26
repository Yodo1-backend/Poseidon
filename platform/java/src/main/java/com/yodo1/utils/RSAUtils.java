package com.yodo1.utils;

//import org.springframework.util.DigestUtils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by YanFeng on 2017/11/16.
 */
public abstract class RSAUtils {

    public static final String SHA1(String source)
    {
        return DigestUtils.shaHex(source);
    }

}
