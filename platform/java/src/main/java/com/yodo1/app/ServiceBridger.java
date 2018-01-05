package com.yodo1.app;

import com.yodo1.formatlog.Yodo1LoggerFactory;
import com.yodo1.formatlog.Yodo1ServiceLogger;
import com.yodo1.poseidon.service.IServiceBridge;
import com.yodo1.poseidon.service.Param;
import com.yodo1.poseidon.service.ParamType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YanFeng on 2018/1/2.
 */
public class ServiceBridger implements IServiceBridge {

    private Yodo1ServiceLogger logger = Yodo1LoggerFactory.getServiceLogger(AppRunner.class);
    @Override
    public Map<java.lang.String,Param> CallService(java.lang.String targetService, Map<String,Param> params)
    {
        HashMap<String,Param> result = new HashMap<>();
        logger.ServiceFunctionLog("Service Working");
        result.put("sayhello",new Param(ParamType.STRING,"hello!"));
        return result;
    }
    @Override
    public void CallServiceOneWay(java.lang.String targetService, Map<java.lang.String,Param> params){}
}
